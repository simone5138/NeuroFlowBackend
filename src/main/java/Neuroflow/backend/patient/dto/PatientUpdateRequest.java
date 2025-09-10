package Neuroflow.backend.patient.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class PatientUpdateRequest {
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
    //TODO getters/setters
}
