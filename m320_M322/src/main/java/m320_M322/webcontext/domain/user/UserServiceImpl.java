package m320_M322.webcontext.domain.user;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import m320_M322.config.generics.ExtendedJpaRepository;
import m320_M322.config.generics.ExtendedServiceImpl;
import m320_M322.webcontext.domain.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    @Transactional
    public User register(User user) {
        log.trace("tryinf to register  new user");

        return savedUser;
    }
}
