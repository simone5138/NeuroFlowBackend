package Neuroflow.backend.pedigree.dto;

import java.time.Instant;

public class PedigreeDto {
    private Long id;
    private Long patientId;
    private String data;
    private Instant updatedAt;
    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
