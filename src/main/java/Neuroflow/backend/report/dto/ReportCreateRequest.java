package Neuroflow.backend.report.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ReportCreateRequest {
    @NotNull private Long treatmentPathId;
    @NotNull private Long patientId;
    @NotNull private Long userId;
    @NotNull private LocalDate openingDate;
    private LocalDate closingDate;
    @NotBlank private String diagnosis;
    @NotBlank private String projectCourse;

    public Long getTreatmentPathId() {
        return treatmentPathId;
    }

    public void setTreatmentPathId(Long treatmentPathId) {
        this.treatmentPathId = treatmentPathId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getProjectCourse() {
        return projectCourse;
    }

    public void setProjectCourse(String projectCourse) {
        this.projectCourse = projectCourse;
    }
}

