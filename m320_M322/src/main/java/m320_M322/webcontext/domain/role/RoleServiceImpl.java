package m320_M322.webcontext.domain.role;

import m320_M322.config.error.BadRequestException;
import m320_M322.config.generics.ExtendedJpaRepository;
import m320_M322.config.generics.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RoleServiceImpl extends ExtendedServiceImpl<Role> implements RoleService{

    public RoleServiceImpl(ExtendedJpaRepository<Role> repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    public Role findByName(String name) {
        return ((RoleRepository) repository).findByName(name);
    }
}
