
package Neuroflow.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.util.Optional;

@Entity
@Table(name ="treatment_path")
@Getter
public class TreatmentPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "date_start", nullable = false)
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @ManyToOne(targetEntity = Patient.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(targetEntity = Report.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id") //can be null. should be possible to add treatment path without still adding report (OSS exp)
    private Report report;

    public TreatmentPath() {}

    public TreatmentPath(String type, String dateStart, String dateEnd, Patient patient, User user, Report report) {
        this.type = type;
        this.dateStart = Date.valueOf(dateStart);
        this.dateEnd = Date.valueOf(dateEnd);
        this.patient = patient;
        this.user = user;
        this.report = report;
    }

    public TreatmentPath(Long id, String type, String dateStart, Optional<String> dateEnd, Patient patient, User user, Optional<Report> report) {
        this.id = id;
        this.type = type;
        this.dateStart = Date.valueOf(dateStart);
        this.dateEnd = dateEnd.map(Date::valueOf).orElse(null);
        this.patient = patient;
        this.user = user;
        this.report = report.orElse(null);
    }


    public TreatmentPath(String type, String dateStart, String dateEnd, Patient patient, User user) {
        this.type = type;
        this.dateStart = Date.valueOf(dateStart);
        this.dateEnd = Date.valueOf(dateEnd);
        this.patient = patient;
        this.user = user;
    }
    public TreatmentPath(String type, String dateStart, Patient patient, User user) {
        this.type = type;
        this.dateStart = Date.valueOf(dateStart);
        this.patient = patient;
        this.user = user;
    }

    public String getDateStart() {
        return dateStart.toString();
    }

    public Optional<String> getDateEnd() {
        return Optional.ofNullable(dateEnd).map(Date::toString);
        /* ===
        if (dateEnd.isPresent())
            return Optional.of(dateEnd.get().toString());
        else return Optional.empty();
         */
    }


}
