package crv.hospital.diagnoses.logic;


import crv.hospital.diagnoses.communication.clients.TreatmentsClient;
import crv.hospital.diagnoses.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {
    private final DoctorExamines doctorExamines;
    private final TreatmentsClient treatmentsClient;

    public DiagnosisRoom(DoctorExamines doctorExamines, TreatmentsClient treatmentsClient) {
        this.doctorExamines = doctorExamines;
        this.treatmentsClient = treatmentsClient;
    }

    public Patient diagnose(Patient patient) {
        doctorExamines.diagnose(patient); // setting the diagnose
        //System.out.println("Patient: "+ patient.getName() + "; symptoms: " + patient.getSymptoms() +  "; diagnosed with " + patient.getDiagnosis());

        return treatmentsClient.sendToBeTreated(patient);// sending patient to be treated
    }
}
