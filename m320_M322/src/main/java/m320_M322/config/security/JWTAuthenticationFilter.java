package m320_M322.config.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import m320_M322.config.security.helpers.AuthorizationSchemas;
import m320_M322.config.security.helpers.Credentials;
import m320_M322.config.security.helpers.JwtProperties;
import m320_M322.webcontext.domain.user.UserDetailsImpl;
import m320_M322.webcontext.domain.user.dto.UserMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Log4j2
public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final JwtProperties jwtProperties;
    private final UserMapper userMapper;

    public JWTAuthenticationFilter(RequestMatcher requestMatcher, AuthenticationManager authenticationManager,
                                   JwtProperties jwtProperties, UserMapper userMapper) {
        super(requestMatcher, authenticationManager);
        this.jwtProperties = jwtProperties;
        this.userMapper = userMapper;
    }

    private String generateToken(Authentication authResult) {
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());

        return Jwts.builder()
                .setClaims(Map.of("sub", userDetailsImpl.user()
                        .getId(), "authorities", userDetailsImpl.getAuthorities()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpirationMillis()))
                .setIssuer(jwtProperties.getIssuer())
                .signWith(Keys.hmacShaKeyFor(keyBytes))
                .compact();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            Credentials credentials = new ObjectMapper().readValue(request.getInputStream(), Credentials.class);
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword()));
        } catch (IOException e) {
            log.error("Exception while Authentication thrown.", e);
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException {
        response.addHeader(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + generateToken(authResult));
        response.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
        response.getWriter().write(new ObjectMapper().writeValueAsString(userMapper.toDTO(userDetailsImpl.user())));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) {
        SecurityContextHolder.clearContext();
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
