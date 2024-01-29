package m320_M322.webcontext.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import m320_M322.config.generics.ExtendedDTO;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserRegisterDTO extends ExtendedDTO {

    @NotBlank
    @Length(max = 255)
    private String firstName;

    @NotBlank
    @Length(max = 255)
    private String lastName;

    @Email
    @NotBlank
    @Length(max = 255)
    private String email;

    @NotBlank
    @Length(max = 255)
    private String password;
}
