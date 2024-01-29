package m320_M322.webcontext.domain.role;

import java.util.Optional;

import m320_M322.config.generics.ExtendedJpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository extends ExtendedJpaRepository<Role> {

    /**
     * Get Role by its name
     * @param name of Role
     * @return Role Entity
     */
    Role findByName(String name);

}

