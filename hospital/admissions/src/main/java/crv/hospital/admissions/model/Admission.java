package io.everyonecodes.w1springbeans.drhouseadmission.model;

import io.everyonecodes.w1springbeans.drhouseadmission.clients.DiagnosesClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Admission {

    private final UUIDProvider uuidProvider;
    private final DiagnosesClient diagnosesClient;

    public Admission(UUIDProvider uuidProvider, DiagnosesClient diagnosesClient) {
        this.uuidProvider = uuidProvider;
        this.diagnosesClient = diagnosesClient;
    }

    // most likely I don't have to create a new patient?
    public Patient admit(Patient patient){
        diagnosesClient.send(patient);
        return new Patient(uuidProvider.provideUUID(patient), patient.getName());
    }

}
