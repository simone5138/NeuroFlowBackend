package Neuroflow.backend.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Request body used to update a user's password.
 */
@Data
public class UserPasswordUpdateRequest {
    @NotBlank @Size(min=8)
    private String newPassword;
}


