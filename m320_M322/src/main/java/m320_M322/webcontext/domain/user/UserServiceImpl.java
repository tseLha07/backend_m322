package m320_M322.webcontext.domain.user;

import lombok.extern.log4j.Log4j2;
import m320_M322.config.generics.ExtendedJpaRepository;
import m320_M322.config.generics.ExtendedServiceImpl;
import m320_M322.webcontext.domain.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.HashSet;

@Log4j2
@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Autowired
    protected UserServiceImpl(ExtendedJpaRepository<User> repository, RoleService roleService, PasswordEncoder passwordEncoder) {
        super(repository);
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.trace("trying to load User by username");
        return ((UserRepository) repository).findByEmail(email)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public User register(User user) {
        log.trace("trying to register a new user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var role = roleService.findByName("USER");
        user.setRoles(new HashSet<>(Collections.singletonList(role)));
        var savedUser = save(user);
        log.debug("registered a new user");
        return savedUser;
    }
}
