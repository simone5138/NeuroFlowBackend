package Neuroflow.backend.user.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

/**
 * Request body for creating a {@code User}.
 *
 * <p>Lombok has been removed from this project; therefore, explicit getters
 * and setters are implemented to expose the request properties.</p>
 */
public class UserCreateRequest {
    @NotBlank @Size(max=255) private String username;
    @NotBlank @Email         private String email;
    @NotBlank @Size(min=8)   private String password; // in chiaro SOLO qui, verrà hashata nel service
    @NotBlank @Size(max=255) private String firstName;
    @NotBlank @Size(max=255) private String lastName;
    private LocalDate dateBirth;
    @Size(max=255)           private String address;

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

    public LocalDate getDateBirth() { return dateBirth; }
    public void setDateBirth(LocalDate dateBirth) { this.dateBirth = dateBirth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
