package Neuroflow.backend.patient.controller;

import Neuroflow.backend.patient.dto.*;
import Neuroflow.backend.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service) { this.service = service; }

    @GetMapping public Page<PatientDto> list(Pageable p) { return service.list(p); }
    @GetMapping("/frontend") public Page<PatientFrontendDto> listFrontend(Pageable p) { return service.listFrontend(p); }
    @GetMapping("/{id}") public PatientDto get(@PathVariable Long id) { return service.get(id); }
    @PostMapping public PatientDto create(@Valid @RequestBody PatientCreateRequest r) { return service.create(r); }
    @PutMapping("/{id}") public PatientDto update(@PathVariable Long id, @Valid @RequestBody PatientUpdateRequest r) { return service.update(id, r); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}

