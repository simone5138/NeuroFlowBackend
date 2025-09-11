package Neuroflow.backend.user.dto;

import jakarta.validation.constraints.*;

import Neuroflow.backend.user.entity.User.Role;
import lombok.Data;

/**
 * Request body for creating a {@code User}.
 *
 * <p>The {@link Data} annotation supplies the required getters and setters for
 * the mapper and service layers.</p>
 */
@Data
public class UserCreateRequest {
    @NotBlank @Size(max=64)  private String username;
    @NotBlank @Email         private String email;
    @NotBlank @Size(min=8)   private String password; // in chiaro SOLO qui, verrà hashata nel service
    @Size(max=80)            private String firstName;
    @Size(max=80)            private String lastName;
    private Role role = Role.USER;
    private boolean enabled = true;
}
