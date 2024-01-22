package m320_M322.webcontext.domain.role;

import jakarta.validation.Valid;
import m320_M322.webcontext.domain.role.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    private final RoleMapper roleMapper;

    @Autowired
    public RoleController(RoleService roleservice, RoleMapper roleMapper) {
        this.roleService = roleservice;
        this.roleMapper = roleMapper;
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<RoleDTO> getById(@PathVariable String id) {
        Role role = roleService.findById(id);
        return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    public @ResponseBody ResponseEntity<List<RoleDTO>> getAll() {
        List<Role> roles = roleService.findAll();
        return new ResponseEntity<>(roleMapper.toDTOs(roles), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<RoleDTO> create(@Valid @RequestBody RoleDTO roleDTO) {
        Role role = roleService.save(roleMapper.fromDTO(roleDTO));
        return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.CREATED);
    }

    @PostMapping({"/{roleId}/authorities/{authorityId}", "/{roleId}/authorities/{authorityId}/"})
    public ResponseEntity<RoleDTO> addAuthorityToRole(@PathVariable String roleId, @PathVariable String authorityId) {
        Role role = roleService.addAuthorityToRole(roleId, authorityId);
        return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}", "/{id}/"})
    public ResponseEntity<RoleDTO> updateById(@PathVariable String id, @RequestBody @Valid RoleDTO roleDTO) {
        Role role = roleService.updateById(id, roleMapper.fromDTO(roleDTO));
        return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        roleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{roleId}/authorities/{authorityId}", "/{roleId}/authorities/{authorityId}/"})
    public ResponseEntity<RoleDTO> removeAuthorityFromRole(@PathVariable String roleId,
                                                           @PathVariable String authorityId) {
        Role role = roleService.removeAuthorityFromRole(roleId, authorityId);
        return new ResponseEntity<>(roleMapper.toDTO(role), HttpStatus.NO_CONTENT);
    }

}
