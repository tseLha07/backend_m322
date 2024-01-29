package m320_M322.webcontext.domain.user.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import m320_M322.config.generics.ExtendedDTO;
import m320_M322.webcontext.domain.role.RoleDTO;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserDTO extends ExtendedDTO {

    @NotBlank
    @Length(min = 1, max = 255)
    private String firstName;

    @NotBlank
    @Length(min = 1, max = 255)
    private String lastName;

    @Email
    @NotBlank
    @Length(min = 1, max = 255)
    private String email;

    @Valid
    private Set<RoleDTO> roles;
}
