package Neuroflow.backend.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_users_username", columnNames = "username"),
                @UniqueConstraint(name = "uk_users_email", columnNames = "email")
        })
public class User {

    public enum Role { ADMIN, USER }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String username;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Column(length = 80) private String firstName;
    @Column(length = 80) private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private Role role = Role.USER;

    @Column(nullable = false)
    private boolean enabled = true;

    // getters/setters
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; } public void setUsername(String u) { this.username = u; }
    public String getEmail() { return email; } public void setEmail(String e) { this.email = e; }
    public String getPasswordHash() { return passwordHash; } public void setPasswordHash(String p) { this.passwordHash = p; }
    public String getFirstName() { return firstName; } public void setFirstName(String f) { this.firstName = f; }
    public String getLastName() { return lastName; } public void setLastName(String l) { this.lastName = l; }
    public Role getRole() { return role; } public void setRole(Role r) { this.role = r; }
    public boolean isEnabled() { return enabled; } public void setEnabled(boolean e) { this.enabled = e; }
}
