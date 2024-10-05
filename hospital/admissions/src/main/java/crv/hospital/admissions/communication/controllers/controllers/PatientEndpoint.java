package crv.hospital.admissions.communication.controllers.controllers;


import crv.hospital.admissions.logic.Admission;
import crv.hospital.admissions.model.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    Admission admission;
    public PatientEndpoint(Admission admission) {
        this.admission = admission;
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return admission.admit(patient);
    }

}
