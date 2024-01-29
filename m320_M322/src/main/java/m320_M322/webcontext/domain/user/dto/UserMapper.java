package m320_M322.webcontext.domain.user.dto;

import m320_M322.config.generics.ExtendedDTOMapper;
import m320_M322.webcontext.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends ExtendedDTOMapper<User, UserDTO> {
}
