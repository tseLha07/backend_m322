package m320_M322.webcontext.domain.user;

import m320_M322.config.generics.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ExtendedJpaRepository<User> {
    Optional<User> findByEmail(String email);
}
