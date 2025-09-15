package Neuroflow.backend.patient.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "patient")
public class Patient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
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

    @Column(name = "fiscal_code")
    private String fiscalCode;

    public Patient() {}

    public Patient(String firstName,
                   String lastName,
                   String dateBirth,
                   String cityBirth,
                   String address,
                   String gender,
                   String occupation,
                   String nationality,
                   Integer studyYears,
                   String maritalStatus,
                   boolean caregiver,
                   String phoneNumber,
                   String mail,
                   String fiscalCode) {
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
        this.fiscalCode = fiscalCode;
    }

    public Patient(Long id,
                   String firstName,
                   String lastName,
                   String dateBirth,
                   String cityBirth,
                   String address,
                   String gender,
                   String occupation,
                   String nationality,
                   Integer studyYears,
                   String maritalStatus,
                   boolean caregiver,
                   String phoneNumber,
                   String mail,
                   String fiscalCode) {
        this(firstName, lastName, dateBirth, cityBirth, address, gender, occupation,
             nationality, studyYears, maritalStatus, caregiver, phoneNumber, mail, fiscalCode);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCityBirth() {
        return cityBirth;
    }

    public void setCityBirth(String cityBirth) {
        this.cityBirth = cityBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getStudyYears() {
        return studyYears;
    }

    public void setStudyYears(Integer studyYears) {
        this.studyYears = studyYears;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public boolean isCaregiver() {
        return caregiver;
    }

    public void setCaregiver(boolean caregiver) {
        this.caregiver = caregiver;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }
}

