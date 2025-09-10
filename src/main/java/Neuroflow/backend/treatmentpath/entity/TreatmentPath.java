package Neuroflow.backend.treatmentpath.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class TreatmentPath {
    @Entity
    @Table(name = "treatment_path")
    public class TreatmentPath {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)              // valuta enum se hai un set finito di tipi
        private String type;

        @Column(name = "date_start", nullable = false)
        private LocalDate dateStart;

        @Column(name = "date_end")
        private LocalDate dateEnd;

        // Per semplicità usiamo gli ID; in futuro puoi sostituirli con relazioni JPA (@ManyToOne)
        @Column(name = "patient_id", nullable = false)
        private Long patientId;

        @Column(name = "report_id")
        private Long reportId;

        @Column(name = "user_id")
        private Long userId;

        // --- getters & setters ---
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public LocalDate getDateStart() { return dateStart; }
        public void setDateStart(LocalDate dateStart) { this.dateStart = dateStart; }

        public LocalDate getDateEnd() { return dateEnd; }
        public void setDateEnd(LocalDate dateEnd) { this.dateEnd = dateEnd; }

        public Long getPatientId() { return patientId; }
        public void setPatientId(Long patientId) { this.patientId = patientId; }

        public Long getReportId() { return reportId; }
        public void setReportId(Long reportId) { this.reportId = reportId; }

        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
    }
}
