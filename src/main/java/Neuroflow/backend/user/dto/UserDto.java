package Neuroflow.backend.user.dto;

import java.time.LocalDate;

/**
 * Data transfer object for {@code User}.
 *
 * <p>This class intentionally avoids Lombok to keep the project free from
 * annotation processing requirements. Explicit getters and setters are
 * provided so that the mapper and service layers can interact with the
 * properties without relying on generated code.</p>
 */
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateBirth;
    private String address;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

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
