package Neuroflow.backend.patient.service;

import Neuroflow.backend.patient.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientService {
    Page<PatientDto> list(Pageable pageable);
    PatientDto get(Long id);
    PatientDto create(PatientCreateRequest req);
    PatientDto update(Long id, PatientUpdateRequest req);
    void delete(Long id);

    Page<PatientFrontendDto> listFrontend(Pageable pageable);
}
