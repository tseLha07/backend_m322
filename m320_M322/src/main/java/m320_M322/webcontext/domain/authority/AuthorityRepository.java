package m320_M322.webcontext.domain.authority;

import m320_M322.config.generics.ExtendedJpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends ExtendedJpaRepository<Authority> {
    /**
     * get an Authority by its name
     * @param name of Authority String
     * @return an Optional Authority
     *
     * @see Authority
     */
    Optional<Authority> findByName(String name);

    /**
     * delete an authority by name
     * @param name of Authority String
     *
     * @see Authority
     */
    void deleteByName(String name);

    /**
     * deletes connection between roles with the authority id
     * @param id Authority String
     *
     * @see Authority
     */
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from role_authority where authority_id = ?")
    void deleteRelationsToRolesById(String id);
}
