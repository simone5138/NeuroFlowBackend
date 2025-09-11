package Neuroflow.backend.user.dto;

import jakarta.validation.constraints.*;
import Neuroflow.backend.user.entity.User.Role;

/**
 * Request body for updating an existing {@code User}.
 *
 * <p>Supplies explicit getters and setters so that clients can read and modify
 * the fields.</p>
 */
public class UserUpdateRequest {
    @NotBlank @Email private String email;
    @Size(max=80)    private String firstName;
    @Size(max=80)    private String lastName;
    private Role role;
    private boolean enabled;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
