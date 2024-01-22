package m320_M322.webcontext.domain.role.mapper;

import m320_M322.config.generics.ExtendedDTOMapper;
import m320_M322.webcontext.domain.role.Role;
import m320_M322.webcontext.domain.role.RoleDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends ExtendedDTOMapper<Role, RoleDTO> {

    @Named("toWithoutAuthoritiesDTO")
    RoleDTO.WithoutAuthorities toWithoutAuthoritiesDTO(Role role);

    @IterableMapping(qualifiedByName = "toWithoutAuthoritiesDTO")
    Collection<RoleDTO.WithoutAuthorities> toWithoutAuthoritiesDTOs(Collection<Role> roles);
}