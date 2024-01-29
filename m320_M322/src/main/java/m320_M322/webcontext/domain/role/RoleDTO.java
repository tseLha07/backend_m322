package m320_M322.webcontext.domain.role;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import m320_M322.config.generics.ExtendedDTO;
import m320_M322.webcontext.domain.authority.AuthorityDTO;

import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class RoleDTO extends ExtendedDTO {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Valid
    private Set<AuthorityDTO> authorities;

    public RoleDTO(UUID id, String name, Set<AuthorityDTO> authorities) {
        super(id);
        this.name = name;
        this.authorities = authorities;
    }
}

