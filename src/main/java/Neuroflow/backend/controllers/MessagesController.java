package Neuroflow.backend.controllers;

import Neuroflow.backend.entities.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "https://neuroflow.serveo.net", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
//@RequestMapping("/api")
public class MessagesController {
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private TreatmentPathService treatmentPathService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private NeurologicalExaminationService neurologicalExaminationService;


    /**
     * POST /signin
     * returns an AuthResponse with json structure
     * message: string (eg: "logged in successfully")
     * success: boolean (true or false)
     * userid: number - optional. only if user exists
     * username: string - optional. only if user exists
     *
     * @param @RequestBody SignInRequest
     * @return ResponseEntity<String>
     */
    //TODO: change ResponseEntity into json handle
    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody SignInRequest request) {
        Optional<User> user = userService.find(request.getUsername(), request.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok("{" +
                    "\"message\": \"logged in successfully\", " +
                    "\"success\": true, " +
                    "\"userId\": "+user.get().getId()+", " +
                    "\"username\": \""+user.get().getUsername()+"" +
                    "\"}");
        } else {
            return ResponseEntity.ok("{" +
                    "\"message\": \"Login failed\", "+
                    "\"success\": false "+
                    "}");
        }
    }

    @GetMapping("/online")
    public ResponseEntity<String> online() {
        return ResponseEntity.ok("{\"message\": \"logged in successfully\", \"success\": true,}");
    }

    /**
     * POST /signup
     * Returns an AuthResponse with json structure:
     * message: string ("user created")
     * success: boolean (true or false)
     * @param request
     * @return ResponseEntity<String>
     */
    //TODO: change ResponseEntity into json handle
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest request) {
        User user = new User(request.getUsername(), request.getPassword(), request.getEmail(), request.getFirstName(), request.getLastName(), request.getDateBirth(), request.getAddress());
        userService.create(user);
        return ResponseEntity.ok("{\"message\": \"User created\", \"success\": true}");
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        Patient patient = new Patient(new String("pasticcio"),
                new String("ciccio"),
                new String("2000-01-01"),
                new String("Foggia"),
                new String("Via Donatello"),
                new String("M"),
                new String("Operaio"),
                new String("Italiano"),
                2,
                new String("Celibe"),
                false,
                new String("0881"),
                new String("ciccio@ciccio.ciccio"));
        patientService.create(patient);
        return ResponseEntity.ok("{\"message\": \" , \"success\": true}");
    }

    /**
     * GET /listpatient listPatient
     * returns a list of patients
     * @return ResponseEntity<String>
     */

    @GetMapping("/listpatient")
    public ResponseEntity<String> listPatient() {
        List<Patient> patients = patientService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("status", true);
        rootNode.put("patients", objectMapper.createArrayNode());

        for (Patient patient : patients) {
            ObjectNode patientNode = objectMapper.createObjectNode();
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
            ((ArrayNode)rootNode.get("patients")).add(patientNode);
        }

        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(rootNode));
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting object to JSON");
        }
    }

    /**
     * POST /new-patient createPatient
     * get a new patients fron the frontend and writes it into the database.
     * returns the status of the operation and the id
     * @param patientJson
     * @return ResponseEntity<String>
     */
    @PostMapping("/new-patient")
    public ResponseEntity<String> createPatient(@RequestBody ObjectNode patientJson) {
        Patient patient = new Patient(
                patientJson.get("firstName").asText(),
                patientJson.get("lastName").asText(),
                patientJson.get("dateBirth").asText(),
                patientJson.get("cityBirth").asText(),
                patientJson.get("address").asText(),
                patientJson.get("gender").asText(),
                patientJson.get("occupation").asText(),
                patientJson.get("nationality").asText(),
                patientJson.get("studyYears").asInt(),
                patientJson.get("maritalStatus").asText(),
                patientJson.get("caregiver").asBoolean(),
                patientJson.get("phoneNumber").asText(),
                patientJson.get("mail").asText());
        patientService.create(patient);
        return ResponseEntity.ok("{\"message\": \"Patient created\", \"success\": true, \"id\": " + patient.getId() + "}");    }

    /**
     * GET /patient getPatient
     * get a patient by id
     * @param id
     * @return
     */
    @GetMapping("/patient")
    public ResponseEntity<String> getPatient(@RequestParam(value = "id") Long id) {
        Patient patient = patientService.find(id);
       if (patient != null) {
           ObjectMapper objectMapper = new ObjectMapper();
           ObjectNode rootNode = objectMapper.createObjectNode();
           rootNode.put("status", true);
           ObjectNode patientNode = objectMapper.createObjectNode();
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
           rootNode.put("patient", patientNode);

           try {
               return ResponseEntity.ok(objectMapper.writeValueAsString(rootNode));
           } catch (JsonProcessingException e) {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting object to JSON");
           }
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Patient not found\", \"success\": false}");
           // return ResponseEntity.notFound().build();
       }

    }

    /**
     * POST /patient updateUser
     * update a patient
     * @param patientJson
     * @return ResponseEntity<String>
     */
    @PostMapping("/patient")
    public ResponseEntity<String> updateUser(@RequestBody ObjectNode patientJson) {
        try {
            if (patientJson.has("id")) {
                patientService.update(new Patient(
                        patientJson.get("id").asLong(),
                        patientJson.get("firstName").asText(),
                        patientJson.get("lastName").asText(),
                        patientJson.get("dateBirth").asText(),
                        patientJson.get("cityBirth").asText(),
                        patientJson.get("address").asText(),
                        patientJson.get("gender").asText(),
                        patientJson.get("occupation").asText(),
                        patientJson.get("nationality").asText(),
                        patientJson.get("studyYears").asInt(),
                        patientJson.get("maritalStatus").asText(),
                        patientJson.get("caregiver").asBoolean(),
                        patientJson.get("phoneNumber").asText(),
                        patientJson.get("mail").asText()
                ));
            } else throw new IllegalArgumentException("Missing 'id' field in JSON");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"message\": \"Missing 'id' field in JSON\", \"success\": false}");
        }
        return ResponseEntity.ok("{\"message\": \"User updated\", \"success\": true}");

    }

    /**
     * DELETE /patient deletePatient
     * delete a patient from the id
     * @param id
     * @return
     */
    @DeleteMapping("/patient")
    public ResponseEntity<String> deletePatient(@RequestParam Long id) {
        patientService.delete(id);
        return ResponseEntity.ok("{\"message\": \"Patient deleted successfully\", \"success\": true}");
    }

    @GetMapping("/treatmentlist")  //yes, it's the opposite of listpatient... idk
    public ResponseEntity<String> getTreatmentPathList() {
        List<TreatmentPath> treatments = treatmentPathService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("status", true);
        rootNode.put("treatments", objectMapper.createArrayNode());
        for (TreatmentPath treatment : treatments) {
            ObjectNode treatmentNode = objectMapper.createObjectNode();
            treatmentNode.put("id", treatment.getId());
            treatmentNode.put("type", treatment.getType());
            treatmentNode.put("dateStart", treatment.getDateStart());
            treatmentNode.put("patientId", treatment.getPatient().getId());
            if (!Objects.isNull(treatment.getReport())) { //report can be null, since it can still be not created
                treatmentNode.put("reportId", treatment.getReport().getId());
            } else {
                treatmentNode.put("reportId", 0); //for the moment need a value. will change later
            }
            treatmentNode.put("userId", treatment.getUser().getId());
            ((ArrayNode)rootNode.get("treatments")).add(treatmentNode);
        }
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(rootNode));
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting object to JSON");
        }
    }

    @PostMapping("/new-treatmentpath")
    public ResponseEntity<String> createTreatmentPath(@RequestBody ObjectNode treatmentJson) {
        TreatmentPath treatmentPath = new TreatmentPath(
            treatmentJson.get("type").asText(),
            treatmentJson.get("dateStart").asText(),
            //treatmentJson.get("dateEnd").asText(),
            patientService.find(treatmentJson.get("patientId").asLong()),
            //treatmentJson.get("reportId").asLong(),
            userService.find(treatmentJson.get("userId").asLong())
        );
        treatmentPathService.create(treatmentPath);
        return ResponseEntity.ok("{\"message\": \"Treatment path created\", \"success\": true, \"id\": " + treatmentPath.getId() + "}");
    }

    @GetMapping("/treatmentpath")
    public ResponseEntity<String> getTreatmentPath(@RequestParam Long id) {
        TreatmentPath treatmentPath = treatmentPathService.find(id);
        if (treatmentPath != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode rootNode = objectMapper.createObjectNode();
            rootNode.put("status", true);
            ObjectNode treatmentNode = objectMapper.createObjectNode();
            treatmentNode.put("id", treatmentPath.getId());
            treatmentNode.put("type", treatmentPath.getType());
            treatmentNode.put("dateStart", treatmentPath.getDateStart());
            treatmentNode.put("dateEnd", treatmentPath.getDateEnd().orElse(""));
            treatmentNode.put("patientId", treatmentPath.getPatient().getId());
            if (!Objects.isNull(treatmentPath.getReport())) { //treatmentPath.getReport().getId() is null, since getReport is already null, so it throws error
                treatmentNode.put("reportId", treatmentPath.getReport().getId());
            } else {
                treatmentNode.put("reportId", 0); //for the moment need a value. will change later
            }
            treatmentNode.put("userId", treatmentPath.getUser().getId());
            rootNode.put("treatmentPath",treatmentNode);
            try {
                return ResponseEntity.ok(objectMapper.writeValueAsString(rootNode));
            } catch (JsonProcessingException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting object to JSON");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Treatment path not found\", \"success\": false}");
        }

    }

    @PostMapping("/treatmentpath")
    public ResponseEntity<String> updateTreatmentPath(@RequestBody ObjectNode treatmentJson) {
        Long id ;
        String type;
        String dateStart;
        Optional<String> dateEnd;
        Patient patient;
        Optional<Report> report;
        User user;
        try {
            id = treatmentJson.get("id").asLong();
            if (!treatmentJson.get("type").asText().isEmpty()) {
                type = treatmentJson.get("type").asText();
            } else throw new IllegalArgumentException("Missing \"type\" field in JSON");
            if (!treatmentJson.get("dateStart").asText().isEmpty()) {
                dateStart = treatmentJson.get("dateStart").asText();
            } else throw new IllegalArgumentException("Missing \"dateStart\" field in JSON");
            if (treatmentJson.get("dateEnd").asText().isEmpty()) {
                dateEnd = Optional.empty();
            } else dateEnd = Optional.of(treatmentJson.get("dateEnd").asText());
            if (treatmentJson.get("patientId").asLong() != 0) { //TODO: check if works
                patient = patientService.find(treatmentJson.get("patientId").asLong());
            } else throw new IllegalArgumentException("Missing \"patientId\" field in JSON");
            if (treatmentJson.get("reportId").asLong() != 0) {
                report = Optional.ofNullable(reportService.find(treatmentJson.get("reportId").asLong()));
            } else report = Optional.empty();
            if (treatmentJson.get("userId").asLong() != 0) {
                user = userService.find(treatmentJson.get("userId").asLong());
            } else throw new IllegalArgumentException("Missing \"userId\" field in JSON");
            treatmentPathService.update(new TreatmentPath(id, type, dateStart, dateEnd, patient, user, report));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"message\": \"" + e.getMessage() + "\", \"success\": false}");
        }
        return ResponseEntity.ok("{\"message\": \"Treatment path updated\", \"success\": true}");
    }

    @DeleteMapping("/treatmentpath")
    public ResponseEntity<String> deleteTreatmentPath(@RequestParam Long id) {
        treatmentPathService.delete(id);
        return ResponseEntity.ok("{\"message\": \"Patient deleted successfully\", \"success\": true}");
    }

    @GetMapping("/reportlist")
    public ResponseEntity<String> getReportList() {
        List<Report> reports = reportService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("status", true);
        rootNode.put("reports", objectMapper.createArrayNode());
        for (Report report : reports) {
            ObjectNode reportNode = objectMapper.createObjectNode();
            reportNode.put("id", report.getId());
            reportNode.put("treatmentPathId", report.getTreatmentPath().getId());
            reportNode.put("patientId", report.getPatient().getId());
            reportNode.put("userId", report.getUser().getId());
            reportNode.put("openingDate", report.getOpeningDate());
            reportNode.put("closingDate", report.getClosingDate()); // should return "", not null...
            reportNode.put("diagnosis", report.getDiagnosis());
            reportNode.put("projectCourse", report.getProjectCourse());
            ((ArrayNode)rootNode.get("reports")).add(reportNode);
        }
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(rootNode));
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting object to JSON");
        }
    }

    @GetMapping("/reportList")
    public ResponseEntity<String> getReportListWithId(@RequestParam Long id){
        List<Report> reports = reportService.findWithId(id);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        rootNode.put("status", true);
        rootNode.put("reports", objectMapper.createArrayNode());
        for (Report report : reports) {
            ObjectNode reportNode = objectMapper.createObjectNode();
            reportNode.put("id", report.getId());
            reportNode.put("treatmentPathId", report.getTreatmentPath().getId());
            reportNode.put("patientId", report.getPatient().getId());
            reportNode.put("userId", report.getUser().getId());
            reportNode.put("openingDate", report.getOpeningDate());
            reportNode.put("closingDate", report.getClosingDate());
            reportNode.put("diagnosis", report.getClosingDate());// should return "", not null...
            reportNode.put("projectCourse", report.getProjectCourse());
            ((ArrayNode)rootNode.get("reports")).add(reportNode);
        }
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(rootNode));
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting object to JSON");
        }
    }

    @GetMapping("/report")
    public ResponseEntity<String> getReport(@RequestParam Long id) {
        Report report = reportService.find(id);
        if (report != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode rootNode = objectMapper.createObjectNode();
            rootNode.put("status", true);
            ObjectNode reportNode = objectMapper.createObjectNode();
            reportNode.put("id", report.getId());
            reportNode.put("treatmentPathId", report.getTreatmentPath().getId());
            reportNode.put("patientId", report.getPatient().getId());
            reportNode.put("userId", report.getUser().getId());
            reportNode.put("openingDate", report.getOpeningDate());
            if (report.getClosingDate().isEmpty()) {
                reportNode.put("closingDate", "");
            } else {
                reportNode.put("closingDate", report.getClosingDate());
            }
            reportNode.put("diagnosis", report.getDiagnosis());
            reportNode.put("projectCourse", report.getProjectCourse());
            rootNode.put("report", reportNode);
            try {
                return ResponseEntity.ok(objectMapper.writeValueAsString(rootNode));
            } catch (JsonProcessingException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting object to JSON");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Treatment path not found\", \"success\": false}");
        }
    }

    @PostMapping("/new-report")
    public ResponseEntity<String> createReport(@RequestBody ObjectNode reportJson) {
        TreatmentPath treatmentPath = treatmentPathService.find(reportJson.get("treatmentPathId").asLong());
        Patient patient = patientService.find(reportJson.get("patientId").asLong());
        User user = userService.find(reportJson.get("userId").asLong());
        String openingDate = reportJson.get("openingDate").asText();
        String closingDate = null; //it's ok if null
        if (!reportJson.get("closingDate").asText().isEmpty())
            closingDate = reportJson.get("closingDate").asText();
        String diagnosis = reportJson.get("diagnosis").asText();
        String projectCourse = reportJson.get("projectCourse").asText();
        Report report = new Report(treatmentPath, patient, user, openingDate, closingDate, diagnosis, projectCourse);
        reportService.create(report);
        return ResponseEntity.ok("{\"message\": \"Report created\", \"success\": true, \"id\": " + report.getId() + "}");
    }


    @PostMapping("/report")
    public ResponseEntity<String> updateReport(@RequestBody ObjectNode reportJson) {
        Long id;
        TreatmentPath treatmentPath;
        Patient patient;
        User user;
        String openingDate;
        String closingDate;
        String diagnosis;
        String projectCourse;
        try {
            if (reportJson.get("id").asLong() != 0)
                id = reportJson.get("id").asLong();
            else throw new IllegalArgumentException("Id cannot be null");
            if (reportJson.get("treatmentPathId").asLong() != 0)
                treatmentPath = treatmentPathService.find(reportJson.get("treatmentPathId").asLong());
            else throw new IllegalArgumentException("cannot find \"treatmentPath\" type in JSON");
            if (reportJson.get("patientId").asLong() != 0)
                patient = patientService.find(reportJson.get("patientId").asLong());
            else throw new IllegalArgumentException("cannot find \"patientId\" type in JSON");
            if (reportJson.get("userId").asLong() != 0)
                user = userService.find(reportJson.get("userId").asLong());
            else throw new IllegalArgumentException("cannot find \"userId\" field in JSON");
            if (!reportJson.get("openingDate").asText().isEmpty())
                openingDate = reportJson.get("openingDate").asText();
            else throw new IllegalArgumentException("cannot find \"openingDate\" field in JSON");
            if (!reportJson.get("closingDate").isEmpty())
                closingDate = reportJson.get("closingDate").asText(); //can be null
            else closingDate = null;
            if (!reportJson.get("diagnosis").asText().isEmpty())
                diagnosis = reportJson.get("diagnosis").asText();
            else throw new IllegalArgumentException("cannot find \"diagnosis\" field in JSON");
            if (!reportJson.get("projectCourse").asText().isEmpty())
                projectCourse = reportJson.get("projectCourse").asText();
            else throw new IllegalArgumentException("cannot find \"projectCouse\" field in JSON");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": " + e.getMessage() + ", \"success\": false}");
        } reportService.update(new Report(id, treatmentPath, patient, user, openingDate, closingDate, diagnosis, projectCourse));
        return ResponseEntity.ok("{\"message\": \"Report updated\", \"success\": true}");
    }

    @DeleteMapping("/report")
    public ResponseEntity<String> deleteReport (@RequestParam long id) {
        reportService.delete(id);
        return ResponseEntity.ok("{\"message\": \"Report deleted\", \"success\": true}");
    }

    @GetMapping("/examination-list")
    public ResponseEntity<String> getExaminationList() {
        List<NeurologicalExamination> exams = neurologicalExaminationService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode root = objectMapper.createObjectNode();
        root.put("status", true);
        root.set("examinations", objectMapper.valueToTree(exams));
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(root));
        } catch (JsonProcessingException e) {
            return ResponseEntity.internalServerError().body("{\"message\": \"Serialization error\"}");
        }
    }

    @GetMapping("/examination")
    public ResponseEntity<String> getExamination(@RequestParam Long id) {
        NeurologicalExamination exam = neurologicalExaminationService.find(id);
        if (exam != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode rootNode = objectMapper.createObjectNode();
            rootNode.put("status", true);

            ObjectNode examNode = objectMapper.createObjectNode();
            examNode.put("id", exam.getId());
            examNode.put("reportId", exam.getReport().getId());
            examNode.put("performed", exam.isPerformed());
            examNode.put("date", "11/11/2011"); //TODO:fix
            examNode.put("reasonNotPerformed", exam.getReasonNotPerformed());

            examNode.put("orientation", exam.getOrientation());
            examNode.put("apraxia", exam.getApraxia());
            examNode.put("psychosis", exam.getPsychosis());
            examNode.put("attention", exam.getAttention());
            examNode.put("behavieur", exam.getBehavior());
            examNode.put("memory", exam.getMemory());
            examNode.put("mood", exam.getMood());
            examNode.put("language", exam.getLanguage());
            examNode.put("agnosia", exam.getAgnosia());
            examNode.put("anosognosia", exam.getAnosognosia());

            examNode.put("palmomental", exam.getPalmomental());
            examNode.put("pseudodulbarEffect", exam.getPseudodulbarEffect());
            examNode.put("trornmer", exam.getTrornmer());
            examNode.put("myerson", exam.getMyerson());
            examNode.put("palmarGrasp", exam.getPalmarGrasp());
            examNode.put("snout", exam.getSnout());
            examNode.put("hoffman", exam.getHoffman());
            examNode.put("yawning", exam.getYawning());
            examNode.put("plantar", exam.getPlantar());
            examNode.put("notStanding", exam.getNotStanding());

            examNode.put("gaitNormal", exam.getGaitNormal());
            examNode.put("myopathic", exam.getMyopathic());
            examNode.put("choreiform", exam.getChoreiform());
            examNode.put("antalgic", exam.getAntalgic());
            examNode.put("hemiplegic", exam.getHemiplegic());
            examNode.put("spasticDisplegic", exam.getSpasticDisplegic());
            examNode.put("bizarre", exam.getBizarre());
            examNode.put("parkinsonian", exam.getParkinsonian());
            examNode.put("ataxic", exam.getAtaxic());
            examNode.put("neuropathic", exam.getNeuropathic());
            examNode.put("sensory", exam.getSensory());
            examNode.put("rombergPositive", exam.getRombergPositive());

            // Se vuoi serializzare i cranialNerves come array semplificato
            ArrayNode nervesNode = objectMapper.createArrayNode();
            if (exam.getCranialNerves() != null) {
                exam.getCranialNerves().forEach(n -> {
                    ObjectNode nerve = objectMapper.createObjectNode();
                    nerve.put("nerve", n.getNerve());
                    nerve.put("side", n.getSide());
                    nerve.put("present", n.getPresent());
                    nervesNode.add(nerve);
                });
            }
            examNode.set("cranialNerves", nervesNode);

            rootNode.set("examination", examNode);
            try {
                return ResponseEntity.ok(objectMapper.writeValueAsString(rootNode));
            } catch (JsonProcessingException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting object to JSON");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Examination not found\", \"success\": false}");
        }
    }
    /*
    public ResponseEntity<String> getExamination(@RequestParam Long id) {
        NeurologicalExamination exam = neurologicalExaminationService.find(id);
        if (exam != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode response = objectMapper.createObjectNode();
            response.put("status", true);
            response.set("examination", objectMapper.valueToTree(exam));
            try {
                return ResponseEntity.ok(objectMapper.writeValueAsString(response));
            } catch (JsonProcessingException e) {
                return ResponseEntity.internalServerError().body("{\"message\": \"Serialization error\"}");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"Examination not found\", \"success\": false}");
        }
    }

     */

    @PostMapping("/new-examination")
    public ResponseEntity<String> createExamination(@RequestBody ObjectNode examinationJson) {
        try {
            // Recupera il report associato
            Long reportId = examinationJson.get("reportId").asLong();
            Report report = reportService.find(reportId);

            // Costruisci l'esame neurologico
            NeurologicalExamination exam = NeurologicalExamination.builder()
                    .report(report)
                    .performed(examinationJson.get("performed").asBoolean())
                    //.date(LocalDate.parse(examinationJson.get("date").asText()))
                    .reasonNotPerformed(examinationJson.get("reasonNotPerformed").asText(null)) // fallback a null

                    // Campi cognitivi
                    .orientation(examinationJson.get("orientation").asBoolean())
                    .apraxia(examinationJson.get("apraxia").asBoolean())
                    .psychosis(examinationJson.get("psychosis").asBoolean())
                    .attention(examinationJson.get("attention").asBoolean())
                    .behavior(examinationJson.get("behavieur").asBoolean())
                    .memory(examinationJson.get("memory").asBoolean())
                    .mood(examinationJson.get("mood").asBoolean())
                    .language(examinationJson.get("language").asBoolean())
                    .agnosia(examinationJson.get("agnosia").asBoolean())
                    .anosognosia(examinationJson.get("anosognosia").asBoolean())

                    // Riflessi e segni
                    .palmomental(examinationJson.get("palmomental").asBoolean())
                    .pseudodulbarEffect(examinationJson.get("pseudodulbarEffect").asBoolean())
                    .trornmer(examinationJson.get("trornmer").asBoolean())
                    .myerson(examinationJson.get("myerson").asBoolean())
                    .palmarGrasp(examinationJson.get("palmarGrasp").asBoolean())
                    .snout(examinationJson.get("snout").asBoolean())
                    .hoffman(examinationJson.get("hoffman").asBoolean())
                    .yawning(examinationJson.get("yawning").asBoolean())
                    .plantar(examinationJson.get("plantar").asBoolean())
                    .notStanding(examinationJson.get("notStanding").asBoolean())

                    // Gait
                    .gaitNormal(examinationJson.get("gaitNormal").asBoolean())
                    .myopathic(examinationJson.get("myopathic").asBoolean())
                    .choreiform(examinationJson.get("choreiform").asBoolean())
                    .antalgic(examinationJson.get("antalgic").asBoolean())
                    .hemiplegic(examinationJson.get("hemiplegic").asBoolean())
                    .spasticDisplegic(examinationJson.get("spasticDisplegic").asBoolean())
                    .bizarre(examinationJson.get("bizarre").asBoolean())
                    .parkinsonian(examinationJson.get("parkinsonian").asBoolean())
                    .ataxic(examinationJson.get("ataxic").asBoolean())
                    .neuropathic(examinationJson.get("neuropathic").asBoolean())
                    .sensory(examinationJson.get("sensory").asBoolean())
                    .rombergPositive(examinationJson.get("rombergPositive").asBoolean())
                    .build();

            // Inserimento delle cranialNerves se presenti (puoi personalizzarla)
//            if (examinationJson.has("cranialNerves") && examinationJson.get("cranialNerves").isArray()) {
//                List<CranialNerve> nerves = new ArrayList<>();
//                examinationJson.get("cranialNerves").forEach(n -> {
//                    CranialNerve cn = new CranialNerve();
//                    cn.setNerve(n.get("nerve").asText());
//                    cn.setSide(n.get("side").asText());
//                    cn.setPresent(n.get("present").asBoolean());
//                    cn.setExamination(exam); // collega l'esame
//                    nerves.add(cn);
//                });
//                exam.setCranialNerves(nerves);
//            }

            // Salva l'esame
            neurologicalExaminationService.create(exam);

            return ResponseEntity.ok("{\"message\": \"Examination created\", \"success\": true, \"id\": " + exam.getId() + "}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"message\": \"Errore nella creazione dell'esame neurologico\", \"success\": false}");
        }
    }

    @PostMapping("/examination")
    public ResponseEntity<String> updateExamination(@RequestBody NeurologicalExamination examination) {
        if (examination.getId() == null) {
            return ResponseEntity.badRequest().body("{\"message\": \"Missing ID for update\", \"success\": false}");
        }
        neurologicalExaminationService.update(examination);
        return ResponseEntity.ok("{\"message\": \"Examination updated\", \"success\": true}");
    }

    @DeleteMapping("/examination")
    public ResponseEntity<String> deleteExamination(@RequestParam Long id) {
        neurologicalExaminationService.delete(id);
        return ResponseEntity.ok("{\"message\": \"Examination deleted\", \"success\": true}");
    }








    @Getter
    private static class SignUpRequest {
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private String dateBirth;
        private String address;

    }

    @Getter
    private static class SignInRequest {
        private String username;
        private String password;
    }
}

