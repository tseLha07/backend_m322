package m320_M322.webcontext.domain.role;

import m320_M322.config.generics.ExtendedService;

import java.util.List;
import java.util.NoSuchElementException;

public interface RoleService extends ExtendedService<Role> {

    Role findByName(String name);

}
