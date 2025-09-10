package Neuroflow.backend.pedigree.service;

import Neuroflow.backend.pedigree.dto.*;

public interface PedigreeService {
    PedigreeDto getByPatientId(Long patientId);
    PedigreeDto upsert(Long patientId, PedigreeUpsertRequest req);
}

