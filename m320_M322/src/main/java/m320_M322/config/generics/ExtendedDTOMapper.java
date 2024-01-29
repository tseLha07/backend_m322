package m320_M322.config.generics;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ExtendedDTOMapper<DM extends ExtendedEntity, DTO extends ExtendedDTO> {

    DM fromDTO(DTO dto);

    DTO toDTO(DM dm);

    List<DTO> toDTOs(List<DM> dms);

}