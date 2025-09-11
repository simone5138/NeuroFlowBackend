package Neuroflow.backend.report.mapper;

import Neuroflow.backend.report.dto.*;
import Neuroflow.backend.report.entity.Report;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportDto toDto(Report e) {
        if (e == null) return null;
        ReportDto d = new ReportDto();
        d.setId(e.getId());
        d.setTreatmentPathId(e.getTreatmentPathId());
        d.setPatientId(e.getPatientId());
        d.setUserId(e.getUserId());
        d.setOpeningDate(e.getOpeningDate());
        d.setClosingDate(e.getClosingDate());
        d.setDiagnosis(e.getDiagnosis());
        d.setProjectCourse(e.getProjectCourse());
        return d;
    }

    public Report toEntity(ReportCreateRequest r) {
        Report e = new Report();
        e.setTreatmentPathId(r.getTreatmentPathId());
        e.setPatientId(r.getPatientId());
        e.setUserId(r.getUserId());
        e.setOpeningDate(r.getOpeningDate());
        e.setClosingDate(r.getClosingDate());
        e.setDiagnosis(r.getDiagnosis());
        e.setProjectCourse(r.getProjectCourse());
        return e;
    }

    public void updateEntity(ReportUpdateRequest r, Report e) {
        e.setTreatmentPathId(r.getTreatmentPathId());
        e.setPatientId(r.getPatientId());
        e.setUserId(r.getUserId());
        e.setOpeningDate(r.getOpeningDate());
        e.setClosingDate(r.getClosingDate());
        e.setDiagnosis(r.getDiagnosis());
        e.setProjectCourse(r.getProjectCourse());
    }
}

