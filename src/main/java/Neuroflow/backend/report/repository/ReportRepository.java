package Neuroflow.backend.report.repository;

import Neuroflow.backend.report.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
    Page<Report> findByPatientId(Long patientId, Pageable pageable);
    Page<Report> findByAuthorUserId(Long authorUserId, Pageable pageable);
}

