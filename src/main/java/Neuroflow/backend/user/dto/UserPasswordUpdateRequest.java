package Neuroflow.backend.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserPasswordUpdateRequest {
    @NotBlank @Size(min=8)
    private String newPassword;
    //TODO getters/setters
}


