package Neuroflow.backend.pedigree.service;

import Neuroflow.backend.pedigree.dto.*;
import Neuroflow.backend.pedigree.entity.Pedigree;
import Neuroflow.backend.pedigree.mapper.PedigreeMapper;
import Neuroflow.backend.pedigree.repository.PedigreeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PedigreeServiceImpl implements PedigreeService {
    private final PedigreeRepository repo;
    private final PedigreeMapper mapper;

    public PedigreeServiceImpl(PedigreeRepository r, PedigreeMapper m) {
        this.repo = r;
        this.mapper = m;
        }

    @Override
    public PedigreeDto getByPatientId(Long patientId) {
        Pedigree e = repo.findByPatientId(patientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pedigree not found for patient " + patientId));
        return mapper.toDto(e);
    }

    @Override
    public PedigreeDto upsert(Long patientId, PedigreeUpsertRequest req) {
        Pedigree e = repo.findByPatientId(patientId).orElseGet(Pedigree::new);
        if (e.getId() == null) {
            e.setCreatedBy(req.getCreatedBy());
        }
        e.setLastModifiedBy(req.getLastModifiedBy());
        e.setPatientId(patientId);
        e.setData(req.getData());
        return mapper.toDto(repo.save(e));
    }
}
