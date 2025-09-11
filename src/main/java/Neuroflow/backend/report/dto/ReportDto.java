package Neuroflow.backend.report.dto;

import java.time.LocalDate;

public class ReportDto {
    private Long id;
    private Long treatmentPathId;
    private Long patientId;
    private Long userId;
    private LocalDate openingDate;
    private LocalDate closingDate;
    private String diagnosis;
    private String projectCourse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

