package Neuroflow.backend.user.dto;

import jakarta.validation.constraints.*;
import Neuroflow.backend.user.entity.User.Role;

public class UserUpdateRequest {
    @NotBlank @Email private String email;
    @Size(max=80)    private String firstName;
    @Size(max=80)    private String lastName;
    private Role role;
    private boolean enabled;
    //TODO getters/setters
}
