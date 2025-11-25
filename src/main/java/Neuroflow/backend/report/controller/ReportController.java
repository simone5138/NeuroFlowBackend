package Neuroflow.backend.report.controller;

import Neuroflow.backend.report.dto.*;
import Neuroflow.backend.report.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService service;
    public ReportController(ReportService s){ this.service=s; }

    @GetMapping
    public Page<ReportDto> list(Pageable p,
                                @RequestParam Optional<Long> patientId,
                                @RequestParam Optional<Long> treatmentPathId,
                                @RequestParam Optional<Long> userId) {
        return service.list(p, patientId, treatmentPathId, userId);
    }

    @GetMapping("/{id}")
    public ReportDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public ReportDto create(@Valid @RequestBody ReportCreateRequest r) {
        return service.create(r);
    }

    @PutMapping("/{id}")
    public ReportDto update(@PathVariable Long id, @Valid @RequestBody ReportUpdateRequest r) {
        return service.update(id, r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

