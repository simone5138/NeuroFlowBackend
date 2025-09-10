package Neuroflow.backend.report.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReportCreateRequest {
    @NotNull  private Long patientId;
    private Long authorUserId;       // opzionale
    @NotBlank private String title;
    private String content;
    //TODO getters/setters
}

