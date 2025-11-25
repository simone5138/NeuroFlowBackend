package Neuroflow.backend.pedigree.controller;

import Neuroflow.backend.pedigree.dto.*;
import Neuroflow.backend.pedigree.service.PedigreeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients/{patientId}/pedigree")
public class PedigreeController {
    private final PedigreeService service;
    public PedigreeController(PedigreeService s){ this.service=s; }

    @GetMapping public PedigreeDto get(@PathVariable Long patientId){ return service.getByPatientId(patientId); }
    @PutMapping public PedigreeDto upsert(@PathVariable Long patientId, @Valid @RequestBody PedigreeUpsertRequest req){
        return service.upsert(patientId, req);
    }
}
