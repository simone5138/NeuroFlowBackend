package Neuroflow.backend.user.dto;

import jakarta.validation.constraints.*;
import Neuroflow.backend.user.entity.User.Role;

/**
 * Request body for creating a {@code User}.
 *
 * <p>Lombok has been removed from this project; therefore, explicit getters
 * and setters are implemented to expose the request properties.</p>
 */
public class UserCreateRequest {
    @NotBlank @Size(max=64)  private String username;
    @NotBlank @Email         private String email;
    @NotBlank @Size(min=8)   private String password; // in chiaro SOLO qui, verrà hashata nel service
    @Size(max=80)            private String firstName;
    @Size(max=80)            private String lastName;
    private Role role = Role.USER;
    private boolean enabled = true;

    // getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
