package Neuroflow.backend.treatmentpath.controller;

import Neuroflow.backend.treatmentpath.dto.*;
import Neuroflow.backend.treatmentpath.service.TreatmentPathService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/treatment-paths")
public class TreatmentPathController {

    private final TreatmentPathService service;

    public TreatmentPathController(TreatmentPathService service) {
        this.service = service;
    }

    @GetMapping
    public Page<TreatmentPathDto> list(Pageable pageable,
                                       @RequestParam Optional<Long> patientId) {
        return service.list(pageable, patientId);
    }

    @GetMapping("/{id}")
    public TreatmentPathDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public TreatmentPathDto create(@Valid @RequestBody TreatmentPathCreateRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public TreatmentPathDto update(@PathVariable Long id,
                                   @Valid @RequestBody TreatmentPathUpdateRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
