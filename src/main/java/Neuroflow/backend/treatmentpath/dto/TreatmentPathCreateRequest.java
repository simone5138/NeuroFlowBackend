package Neuroflow.backend.treatmentpath.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class TreatmentPathCreateRequest {
    @NotBlank
    private String type;

    @NotNull
    private LocalDate dateStart;

    private LocalDate dateEnd;

    @NotNull
    private Long patientId;

    private Long reportId;
    private Long userId;

    // getters & setters
    // ...
}

