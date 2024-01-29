package m320_M322.webcontext.domain.role;


import m320_M322.config.generics.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ExtendedJpaRepository<Role> {

    /**
     * Get Role by its name
     * @param name of Role
     * @return Role Entity
     */
    Role findByName(String name);

}

