package Neuroflow.backend.report.mapper;

import Neuroflow.backend.report.dto.*;
import Neuroflow.backend.report.entity.Report;
import org.springframework.stereotype.Component;

@Component
public class ReportMapper {

    public ReportDto toDto(Report e){
        if (e==null) return null;
        ReportDto d = new ReportDto();
        d.setId(e.getId());
        d.setPatientId(e.getPatientId());
        d.setAuthorUserId(e.getAuthorUserId());
        d.setTitle(e.getTitle());
        d.setContent(e.getContent());
        d.setCreatedAt(e.getCreatedAt());
        d.setUpdatedAt(e.getUpdatedAt());
        return d;
    }

    public Report toEntity(ReportCreateRequest r){
        Report e = new Report();
        e.setPatientId(r.getPatientId());
        e.setAuthorUserId(r.getAuthorUserId());
        e.setTitle(r.getTitle());
        e.setContent(r.getContent());
        return e;
    }

    public void updateEntity(ReportUpdateRequest r, Report e){
        e.setPatientId(r.getPatientId());
        e.setAuthorUserId(r.getAuthorUserId());
        e.setTitle(r.getTitle());
        e.setContent(r.getContent());
    }
}

