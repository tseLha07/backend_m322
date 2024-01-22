package m320_M322.webcontext.domain.authority;

import jakarta.validation.constraints.NotNull;
import m320_M322.config.generics.ExtendedDTO;

public class AuthorityDTO extends ExtendedDTO {
    @NotNull
    private String name;

    public AuthorityDTO() {
        super();
    }

    public AuthorityDTO(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AuthorityDTO setName(String name) {
        this.name = name;
        return this;
    }
}
