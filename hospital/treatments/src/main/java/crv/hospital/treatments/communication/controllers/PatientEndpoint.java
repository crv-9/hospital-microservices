package crv.hospital.treatments.communication.controllers;


import crv.hospital.treatments.logic.NurseCare;
import crv.hospital.treatments.model.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final NurseCare nurse;


    public PatientEndpoint(NurseCare nurse) {
        this.nurse = nurse;

    }

    // post a patient which will then be treated
    @PostMapping()
    public Patient addTreatmentToPatient(@RequestBody Patient patient) {
        nurse.handlePatient(patient);
        return patient;
    }
}
