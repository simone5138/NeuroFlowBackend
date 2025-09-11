package Neuroflow.backend.pedigree.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public class PedigreeUpsertRequest {
    @NotNull private Long patientId;
    @NotBlank private String data; // JSON string
    // getters/setters

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
