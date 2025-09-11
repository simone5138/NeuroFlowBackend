package Neuroflow.backend.patient.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import lombok.Data;

/**
 * Request body for creating a {@code Patient}.
 *
 * <p>Lombok's {@link Data} annotation supplies the getters and setters used by
 * the mapper layer.</p>
 */
@Data
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
}
