package Neuroflow.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;

@Entity
@Table(name ="users")
@Getter //eliminates the need to add long getuserId() {} and so on...
public class User {
    @Column(name= "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //auto generated in db with GENERATED ALWAYS AS IDENTITY

    @Column(name= "username", nullable = false, unique = true)
    private String username;

    @Column(name= "password", nullable = false)
    private String password;

    @Column(name= "email", nullable = false)
    private String email;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name = "date_birth")
    private Date dateBirth;

    @Column(name= "address")
    private String address;

    public User() {
    }

    public User(String username, String password, String email, String firstname, String lastname, String datebirth, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstname;
        this.lastName = lastname;
        this.dateBirth = Date.valueOf(datebirth);
        this.address = address;
    }

}