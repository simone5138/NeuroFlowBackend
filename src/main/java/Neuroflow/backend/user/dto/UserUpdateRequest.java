package Neuroflow.backend.user.dto;

import jakarta.validation.constraints.*;
import Neuroflow.backend.user.entity.User.Role;
import lombok.Data;

/**
 * Request body for updating an existing {@code User}.
 *
 * <p>Uses Lombok's {@link Data} annotation to provide the necessary getters and
 * setters.</p>
 */
@Data
public class UserUpdateRequest {
    @NotBlank @Email private String email;
    @Size(max=80)    private String firstName;
    @Size(max=80)    private String lastName;
    private Role role;
    private boolean enabled;
}
