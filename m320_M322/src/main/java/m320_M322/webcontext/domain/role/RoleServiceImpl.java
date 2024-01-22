package m320_M322.webcontext.domain.role;

import m320_M322.config.error.BadRequestException;
import m320_M322.config.generics.ExtendedServiceImpl;
import m320_M322.webcontext.domain.authority.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RoleServiceImpl extends ExtendedServiceImpl<Role> implements RoleService{
    private final AuthorityService authorityService;

    @Autowired
    public RoleServiceImpl(RoleRepository repository, AuthorityService authorityService){
        super(repository);
        this.authorityService = authorityService;
    }

    @Override
    public Role findByName(String name) {
        return ((RoleRepository) repository).findByName(name)
                .orElseThrow(() -> new NoSuchElementException(String.format("Role with name '%s' could not be found", name)));
    }

    @Override
    public void deleteByName(String name) {
        ((RoleRepository) repository).deleteByName(name);
    }

    @Override
    public Role updateById(String id, Role entity) throws NoSuchElementException, BadRequestException {
        super.checkUpdatedEntityId(id, entity);

        LOGGER.debug("Updating Role with ID '{}'", id);

        Role oldRole = findById(id);
        entity.setId(oldRole.getId());

        entity.setAuthorities(oldRole.getAuthorities());
        LOGGER.debug("Set updated Roles Authorities to its old Authorities");

        return repository.save(entity);
    }

    @Override
    public void deleteById(String id) throws NoSuchElementException {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(String.format("Role with ID '%s' not found", id));
        }

        ((RoleRepository) repository).deleteRelationsToUsersById(id);

        repository.deleteById(id);
    }

    @Override
    public Role addAuthorityToRole(String roleId, String authorityId) throws NoSuchElementException {
        Role role = findById(roleId);

        role.getAuthorities().add(authorityService.findById(authorityId));
        LOGGER.debug("Added Authority with ID '{}' to Role with ID '{}'", authorityId, roleId);

        return repository.save(role);
    }

    @Override
    public Role removeAuthorityFromRole(String roleId, String authorityId) throws NoSuchElementException {
        Role role = findById(roleId);

        role.getAuthorities().remove(authorityService.findById(authorityId));
        LOGGER.debug("Removed Authority with ID '{}' from Role with ID '{}'", authorityId, roleId);

        return repository.save(role);
    }

}
