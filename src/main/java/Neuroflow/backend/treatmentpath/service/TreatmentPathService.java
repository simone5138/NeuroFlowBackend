package Neuroflow.backend.treatmentpath.service;
import Neuroflow.backend.treatmentpath.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TreatmentPathService {
    Page<TreatmentPathDto> list(Pageable pageable, Optional<Long> patientId);
    TreatmentPathDto get(Long id);
    TreatmentPathDto create(TreatmentPathCreateRequest req);
    TreatmentPathDto update(Long id, TreatmentPathUpdateRequest req);
    void delete(Long id);
}