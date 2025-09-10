package Neuroflow.backend.report.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReportUpdateRequest {
    @NotNull  private Long patientId;
    private Long authorUserId;
    @NotBlank private String title;
    private String content;
    //TODO getters/setters
}
