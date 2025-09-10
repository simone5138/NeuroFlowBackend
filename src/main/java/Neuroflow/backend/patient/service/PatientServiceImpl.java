package Neuroflow.backend.patient.service;

import Neuroflow.backend.patient.dto.*;
import Neuroflow.backend.patient.entity.Patient;
import Neuroflow.backend.patient.mapper.PatientMapper;
import Neuroflow.backend.patient.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repo;
    private final PatientMapper mapper;

    public PatientServiceImpl(PatientRepository repo, PatientMapper mapper) {
        this.repo = repo; this.mapper = mapper;
    }

    @Override public Page<PatientDto> list(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::toDto);
    }

    @Override public PatientDto get(Long id) {
        Patient e = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found: " + id));
        return mapper.toDto(e);
    }

    @Override public PatientDto create(PatientCreateRequest req) {
        return mapper.toDto(repo.save(mapper.toEntity(req)));
    }

    @Override public PatientDto update(Long id, PatientUpdateRequest req) {
        Patient e = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found: " + id));
        mapper.updateEntity(req, e);
        return mapper.toDto(repo.save(e));
    }

    @Override public void delete(Long id) {
        if (!repo.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found: " + id);
        repo.deleteById(id);
    }
}

