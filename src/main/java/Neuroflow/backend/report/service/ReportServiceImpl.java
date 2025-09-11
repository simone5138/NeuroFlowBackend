package Neuroflow.backend.report.service;

import Neuroflow.backend.report.dto.*;
import Neuroflow.backend.report.entity.Report;
import Neuroflow.backend.report.mapper.ReportMapper;
import Neuroflow.backend.report.repository.ReportRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository repo;
    private final ReportMapper mapper;

    public ReportServiceImpl(ReportRepository r, ReportMapper m) {
        this.repo = r;
        this.mapper = m;
    }

    @Override
    public Page<ReportDto> list(Pageable p,
                                Optional<Long> patientId,
                                Optional<Long> treatmentPathId,
                                Optional<Long> userId) {
        Page<Report> page = patientId.map(id -> repo.findByPatientId(id, p))
                .orElseGet(() -> treatmentPathId.map(t -> repo.findByTreatmentPathId(t, p))
                        .orElseGet(() -> userId.map(u -> repo.findByUserId(u, p))
                                .orElseGet(() -> repo.findAll(p))));
        return page.map(mapper::toDto);
    }

    @Override
    public ReportDto get(Long id) {
        Report e = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Report not found: " + id));
        return mapper.toDto(e);
    }

    @Override
    public ReportDto create(ReportCreateRequest r) {
        return mapper.toDto(repo.save(mapper.toEntity(r)));
    }

    @Override
    public ReportDto update(Long id, ReportUpdateRequest r) {
        Report e = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Report not found: " + id));
        mapper.updateEntity(r, e);
        return mapper.toDto(repo.save(e));
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Report not found: " + id);
        }
        repo.deleteById(id);
    }
}

