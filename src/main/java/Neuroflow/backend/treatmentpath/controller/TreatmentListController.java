package Neuroflow.backend.treatmentpath.controller;

import Neuroflow.backend.treatmentpath.dto.TreatmentPathDto;
import Neuroflow.backend.treatmentpath.service.TreatmentPathService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Provides a legacy-compatible endpoint for listing treatment paths.
 * <p>
 * The frontend still requests <code>/api/v1/treatmentlist</code>; expose that
 * path as an alias for the modern treatment-path list API so existing clients
 * receive the expected data instead of a 404.
 */
@RestController
@RequestMapping
public class TreatmentListController {

    private final TreatmentPathService treatmentPathService;

    public TreatmentListController(TreatmentPathService treatmentPathService) {
        this.treatmentPathService = treatmentPathService;
    }

    @GetMapping("/treatmentlist")
    public Page<TreatmentPathDto> listTreatmentPaths(Pageable pageable,
                                                     @RequestParam Optional<Long> patientId) {
        return treatmentPathService.list(pageable, patientId);
    }
}

