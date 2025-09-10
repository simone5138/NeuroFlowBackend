package Neuroflow.backend.patient.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;

@Entity
@Table(name ="patient")
@Getter
public class Patient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(name= "first_name", nullable = false)
    private String firstName;

    @Column(name= "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_birth", nullable = false)
    private Date dateBirth;

    @Column(name = "city_birth", nullable = false)
    private String cityBirth;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "study_years")
    private Integer studyYears;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "caregiver")
    private boolean caregiver;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "mail")
    private String mail;

    public Patient(){}

    public Patient(String firstName, String lastName, String dateBirth, String cityBirth, String address, String gender, String occupation, String nationality, Integer studyYears, String maritalStatus, boolean caregiver, String phoneNumber, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = Date.valueOf(dateBirth);
        this.cityBirth = cityBirth;
        this.address = address;
        this.gender = gender;
        this.occupation = occupation;
        this.nationality = nationality;
        this.studyYears = studyYears;
        this.maritalStatus = maritalStatus;
        this.caregiver = caregiver;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }
    public Patient(Long id, String firstName, String lastName, String dateBirth, String cityBirth, String address, String gender, String occupation, String nationality, Integer studyYears, String maritalStatus, boolean caregiver, String phoneNumber, String mail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = Date.valueOf(dateBirth);
        this.cityBirth = cityBirth;
        this.address = address;
        this.gender = gender;
        this.occupation = occupation;
        this.nationality = nationality;
        this.studyYears = studyYears;
        this.maritalStatus = maritalStatus;
        this.caregiver = caregiver;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public String getDateBirth() {
        return dateBirth.toString();
    }

    public boolean getCaregiver() {
        return this.caregiver;
    }

}
