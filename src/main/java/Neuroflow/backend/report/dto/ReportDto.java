package Neuroflow.backend.report.dto;

import java.time.Instant;

public class ReportDto {
    private Long id;
    private Long patientId;
    private Long authorUserId;
    private String title;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;
    //TODO getters/setters
}

