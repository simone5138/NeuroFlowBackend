package Neuroflow.backend.patient.dto;

import java.time.LocalDate;
import lombok.Data;

/**
 * Data transfer object for {@code Patient}.
 *
 * <p>This class mirrors the fields exposed by the REST API and is used by the
 * mapper and service layers. Lombok's {@link Data} annotation generates the
 * required getters, setters and other utility methods at compile time.</p>
 */
@Data
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
}

