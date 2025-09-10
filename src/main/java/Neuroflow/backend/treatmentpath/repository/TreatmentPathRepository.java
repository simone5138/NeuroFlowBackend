package Neuroflow.backend.treatmentpath.repository;

import Neuroflow.backend.treatmentpath.entity.TreatmentPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public class TreatmentPathRepository {
    public interface TreatmentPathRepository extends JpaRepository<TreatmentPath, Long> {
        Page<TreatmentPath> findByPatientId(Long patientId, Pageable pageable);
    }
}
