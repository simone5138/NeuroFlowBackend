package Neuroflow.backend.report.service;

import Neuroflow.backend.report.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReportService {
    Page<ReportDto> list(Pageable pageable, Optional<Long> patientId, Optional<Long> authorUserId);
    ReportDto get(Long id);
    ReportDto create(ReportCreateRequest req);
    ReportDto update(Long id, ReportUpdateRequest req);
    void delete(Long id);
}
