package Neuroflow.backend.user.dto;

import Neuroflow.backend.user.entity.User.Role;
import lombok.Data;

/**
 * Data transfer object for {@code User}.
 *
 * <p>Lombok's {@link Data} annotation generates the standard getters, setters
 * and other utility methods at compile time.</p>
 */
@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private boolean enabled;
}
