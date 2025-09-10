package Neuroflow.backend.treatmentpath.service;

import Neuroflow.backend.treatmentpath.dto.*;
import Neuroflow.backend.treatmentpath.entity.TreatmentPath;
import Neuroflow.backend.treatmentpath.mapper.TreatmentPathMapper;
import Neuroflow.backend.treatmentpath.repository.TreatmentPathRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class TreatmentPathServiceImpl implements TreatmentPathService{
    private final TreatmentPathRepository repo;
    private final TreatmentPathMapper mapper;

    public TreatmentPathServiceImpl(TreatmentPathRepository repo, TreatmentPathMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Page<TreatmentPathDto> list(Pageable pageable, Optional<Long> patientId) {
        return (patientId.isPresent()
                ? repo.findByPatientId(patientId.get(), pageable)
                : repo.findAll(pageable)
        ).map(mapper::toDto);
    }

    @Override
    public TreatmentPathDto get(Long id) {
        TreatmentPath tp = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "TreatmentPath not found: " + id));
        return mapper.toDto(tp);
    }

    @Override
    public TreatmentPathDto create(TreatmentPathCreateRequest req) {
        TreatmentPath entity = mapper.toEntity(req);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public TreatmentPathDto update(Long id, TreatmentPathUpdateRequest req) {
        TreatmentPath entity = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "TreatmentPath not found: " + id));
        mapper.updateEntityFromDto(req, entity);
        return mapper.toDto(repo.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(NOT_FOUND, "TreatmentPath not found: " + id);
        }
        repo.deleteById(id);
    }
}
}
