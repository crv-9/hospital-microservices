package crv.hospital.admissions.logic;


import crv.hospital.admissions.communication.clients.DiagnosesClient;
import crv.hospital.admissions.model.Patient;
import crv.hospital.admissions.model.UUIDProvider;
import org.springframework.stereotype.Service;

@Service
public class Admission {

    private final UUIDProvider uuidProvider;
    private final DiagnosesClient diagnosesClient;

    public Admission(UUIDProvider uuidProvider, DiagnosesClient diagnosesClient) {
        this.uuidProvider = uuidProvider;
        this.diagnosesClient = diagnosesClient;
    }


    public Patient admit(Patient patient){
        patient.setUuid(uuidProvider.provideUUID(patient));
        diagnosesClient.send(patient); // sending patient to diagnoses web client
        return patient;
    }

}
