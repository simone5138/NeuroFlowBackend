package Neuroflow.backend.patient.dto;

import java.time.LocalDate;

/**
 * Data transfer object for {@code Patient}.
 *
 * <p>This class mirrors the fields exposed by the REST API and was previously
 * relying on Lombok to generate boilerplate accessors. To avoid a Lombok
 * dependency at compile time, getters and setters are now written explicitly.</p>
 */
public class PatientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateBirth;
    private String cityBirth;
    private String address;
    private String gender;
    private String occupation;
    private String nationality;
    private Integer studyYears;
    private String maritalStatus;
    private boolean caregiver;
    private String phoneNumber;
    private String mail;
    private String fiscalCode;

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

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }
}


