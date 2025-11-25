package Neuroflow.backend.controllers;

import Neuroflow.backend.entities.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/listpatient")
    public ResponseEntity<ObjectNode> listPatient() {
        List<Patient> patients = patientService.findAll();

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.put("status", true);
        ArrayNode patientsNode = mapper.createArrayNode();

        for (Patient patient : patients) {
            ObjectNode patientNode = mapper.createObjectNode();
            patientNode.put("id", patient.getId());
            patientNode.put("firstName", patient.getFirstName());
            patientNode.put("lastName", patient.getLastName());
            patientNode.put("dateBirth", patient.getDateBirth());
            patientNode.put("cityBirth", patient.getCityBirth());
            patientNode.put("address", patient.getAddress());
            patientNode.put("gender", patient.getGender());
            patientNode.put("occupation", patient.getOccupation());
            patientNode.put("nationality", patient.getNationality());
            patientNode.put("studyYears", patient.getStudyYears());
            patientNode.put("maritalStatus", patient.getMaritalStatus());
            patientNode.put("caregiver", patient.getCaregiver());
            patientNode.put("phoneNumber", patient.getPhoneNumber());
            patientNode.put("mail", patient.getMail());
            patientsNode.add(patientNode);
        }

        rootNode.set("patients", patientsNode);
        return ResponseEntity.ok(rootNode);
    }
}
