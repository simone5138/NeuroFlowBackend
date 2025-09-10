package Neuroflow.backend.treatmentpath.dto;

import java.time.LocalDate;

public class TreatmentPathDto {


    public class TreatmentPathDto {
        private Long id;
        private String type;
        private LocalDate dateStart;
        private LocalDate dateEnd;
        private Long patientId;
        private Long reportId;
        private Long userId;

        // getters & setters
        // ...
    }
}
