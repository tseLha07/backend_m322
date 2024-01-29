package m320_M322.config.security.permissionevaluators;

import lombok.NoArgsConstructor;
import m320_M322.webcontext.domain.user.User;
import m320_M322.webcontext.domain.user.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * This class is for evaluating user permissions in the @PreAuthorize Annotation
 *
 * @author Timofey
 * @since 1.0
 */
@Component
@NoArgsConstructor
public class UserPermissionEvaluator {
    /**
     * Check, if the requested user is the Same user as the user given
     *
     * @param principal get the principal from the request
     * @param userDTO   get the user from the request
     * @return true, if the user given is the same as requested, otherwise return false
     * @since 1.0
     */
    public boolean isSameUser(User principal, UserDTO userDTO) {
        return principal.getEmail().equals(userDTO.getEmail());
    }

    /**
     * Check, if the requested user is the Same user as the user given
     *
     * @param principal get the principal from the request
     * @param id        The User id from the request
     * @return true, if the user given is the same as requested, otherwise return false
     * @since 1.0
     */
    public boolean isSameUser(User principal, UUID id) {
        return principal.getId().equals(id);
    }
}
