package Neuroflow.backend.user.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

/**
 * Request body for updating an existing {@code User}.
 *
 * <p>With Lombok removed, explicit accessor methods are provided for use by the
 * service and mapper layers.</p>
 */
public class UserUpdateRequest {
    @NotBlank @Email private String email;
    @NotBlank @Size(max=255) private String firstName;
    @NotBlank @Size(max=255) private String lastName;
    private LocalDate dateBirth;
    @Size(max=255) private String address;

    // getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getDateBirth() { return dateBirth; }
    public void setDateBirth(LocalDate dateBirth) { this.dateBirth = dateBirth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
