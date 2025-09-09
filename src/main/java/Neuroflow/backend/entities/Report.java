package Neuroflow.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.util.Optional;

@Entity
@Table(name ="report")
@Getter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = TreatmentPath.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_path_id", nullable = false) //ADT Code??
    private TreatmentPath treatmentPath;

    @OneToOne(targetEntity = Patient.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "opening_date", nullable = false)
    private Date openingDate;

    @Column(name = "closing_date")
    private Date closingDate;

    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    @Column(name = "project_course", nullable = false)
    private String projectCourse;

    // will add the type of examination here

    public Report() {}

    public Report(Long id, TreatmentPath treatmentPath, Patient patient, User user, String openingDate, String closingDate, String diagnosis, String projectCourse) {
        this.id = id;
        this.treatmentPath = treatmentPath;
        this.patient = patient;
        this.user = user;
        this.openingDate = Date.valueOf(openingDate);
        this.closingDate = Optional.ofNullable(closingDate).map(Date::valueOf).orElse(null);
        this.diagnosis = diagnosis;
        this.projectCourse = projectCourse;
    }

    public Report(TreatmentPath treatmentPath, Patient patient, User user, String openingDate, String closingDate, String diagnosis, String projectCourse) {
        this.treatmentPath = treatmentPath;
        this.patient = patient;
        this.user = user;
        this.openingDate = Date.valueOf(openingDate);
        this.closingDate = Optional.ofNullable(closingDate).map(Date::valueOf).orElse(null);
        this.diagnosis = diagnosis;
        this.projectCourse = projectCourse;
    }

    public Report (TreatmentPath treatmentPath, Patient patient, User user, String openingDate, String diagnosis, String projectCourse) {
        this.treatmentPath = treatmentPath;
        this.patient = patient;
        this.user = user;
        this.openingDate = Date.valueOf(openingDate);
        this.diagnosis = diagnosis;
        this.projectCourse = projectCourse;
    }

    public String getOpeningDate() {
        return openingDate.toString();
    }

    public String getClosingDate() {
        Optional<Date> closingDate = Optional.ofNullable(this.closingDate);
        return closingDate.map(Date::toString).orElse("");
    }
}
