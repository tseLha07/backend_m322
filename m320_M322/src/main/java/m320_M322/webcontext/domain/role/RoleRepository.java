package m320_M322.webcontext.domain.role;

import java.util.Optional;

import m320_M322.config.generics.ExtendedJpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository extends ExtendedJpaRepository<Role> {

    Optional<Role> findByName(String name);

    void deleteByName(String name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from public.users_role where users_id = ?")
    void deleteRelationsToUsersById(String id);
}

