package m320_M322.webcontext.domain.authority;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import m320_M322.config.generics.ExtendedDTO;

import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class AuthorityDTO extends ExtendedDTO {
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    public AuthorityDTO() {
        super();
    }
    public AuthorityDTO(UUID id, String name) {
        super(id);
        this.name = name;
    }
}
