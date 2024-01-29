package m320_M322.webcontext.domain.user;

import m320_M322.config.generics.ExtendedService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, ExtendedService<User> {

    User register(User user);

}
