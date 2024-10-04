package io.everyonecodes.w1springbeans.drhouseadmission.controllers;

import io.everyonecodes.w1springbeans.drhouseadmission.model.Admission;
import io.everyonecodes.w1springbeans.drhouseadmission.model.Patient;
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
