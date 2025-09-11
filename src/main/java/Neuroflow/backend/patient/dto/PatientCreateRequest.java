package Neuroflow.backend.patient.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

/**
 * Request body for creating a {@code Patient}.
 *
 * <p>Lombok previously generated the accessor methods, but to simplify
 * compilation these methods are now written by hand.</p>
 */
public class PatientCreateRequest {
    @NotBlank private String firstName;
    @NotBlank private String lastName;
    @NotNull @Past private LocalDate dateBirth;
    @NotBlank private String cityBirth;
    @NotBlank private String address;
    @NotBlank private String gender;
    private String occupation;
    private String nationality;
    private Integer studyYears;
    private String maritalStatus;
    private boolean caregiver;
    @NotBlank private String phoneNumber;
    @Email private String mail;

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

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
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
}

