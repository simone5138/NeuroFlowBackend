package Neuroflow.backend.pedigree.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public class PedigreeUpsertRequest {
    @NotNull private Long patientId;
    @NotBlank private String data; // JSON string
    // getters/setters
}
