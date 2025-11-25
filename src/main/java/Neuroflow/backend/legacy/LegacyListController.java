package Neuroflow.backend.legacy;

import Neuroflow.backend.patient.dto.PatientDto;
import Neuroflow.backend.patient.service.PatientService;
import Neuroflow.backend.report.dto.ReportDto;
import Neuroflow.backend.report.service.ReportService;
import Neuroflow.backend.treatmentpath.dto.TreatmentPathDto;
import Neuroflow.backend.treatmentpath.service.TreatmentPathService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping
public class LegacyListController {

    private final PatientService patientService;
    private final ReportService reportService;
    private final TreatmentPathService treatmentPathService;

    public LegacyListController(PatientService patientService, ReportService reportService,
                                TreatmentPathService treatmentPathService) {
        this.patientService = patientService;
        this.reportService = reportService;
        this.treatmentPathService = treatmentPathService;
    }

    @GetMapping("/listpatient")
    public Page<PatientDto> listPatients(Pageable pageable) {
        return patientService.list(pageable);
    }

    @GetMapping("/reportlist")
    public Page<ReportDto> listReports(Pageable pageable,
                                       @RequestParam Optional<Long> patientId,
                                       @RequestParam Optional<Long> treatmentPathId,
                                       @RequestParam Optional<Long> userId) {
        return reportService.list(pageable, patientId, treatmentPathId, userId);
    }

    @GetMapping("/treatmentlist")
    public Page<TreatmentPathDto> listTreatmentPaths(Pageable pageable,
                                                    @RequestParam Optional<Long> patientId) {
        return treatmentPathService.list(pageable, patientId);
    }
}
