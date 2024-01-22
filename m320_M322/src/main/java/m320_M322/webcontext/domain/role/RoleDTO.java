package m320_M322.webcontext.domain.role;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import m320_M322.config.generics.ExtendedDTO;
import m320_M322.webcontext.domain.authority.AuthorityDTO;

import java.util.Set;

public class RoleDTO extends ExtendedDTO {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    private Set<AuthorityDTO> authorities;

    public RoleDTO() {
        this.name = "";
        this.authorities = null;
    }

    public String getName() {
        return name;
    }

    public RoleDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Set<AuthorityDTO> getAuthorities() {
        return authorities;
    }

    public RoleDTO setAuthorities(Set<AuthorityDTO> authorities) {
        this.authorities = authorities;
        return this;
    }

    public static class WithoutAuthorities extends ExtendedDTO {

        @NotNull
        @Size(min = 1, max = 255)
        private String name;

        public WithoutAuthorities() {
            this.name = "";
        }

        public String getName() {
            return name;
        }

        public WithoutAuthorities setName(String name) {
            this.name = name;
            return this;
        }

    }
}

