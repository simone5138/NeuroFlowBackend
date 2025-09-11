package Neuroflow.backend.report.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "treatment_path_id", nullable = false)
    private Long treatmentPathId;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "opening_date", nullable = false)
    private LocalDate openingDate;

    @Column(name = "closing_date")
    private LocalDate closingDate;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String diagnosis;

    @Column(name = "project_course", columnDefinition = "TEXT", nullable = false)
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

