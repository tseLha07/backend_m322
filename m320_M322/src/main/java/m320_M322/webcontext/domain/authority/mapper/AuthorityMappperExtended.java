package m320_M322.webcontext.domain.authority.mapper;

import m320_M322.config.generics.ExtendedDTOMapper;
import m320_M322.webcontext.domain.authority.Authority;
import m320_M322.webcontext.domain.authority.AuthorityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMappperExtended extends ExtendedDTOMapper<Authority, AuthorityDTO> {
}
