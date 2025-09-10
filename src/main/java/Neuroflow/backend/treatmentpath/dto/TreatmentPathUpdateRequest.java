package Neuroflow.backend.treatmentpath.dto;

public class TreatmentPathUpdateRequest {
    package it.yourorg.neuroflow.treatmentpath.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

    public class TreatmentPathUpdateRequest {

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
}
