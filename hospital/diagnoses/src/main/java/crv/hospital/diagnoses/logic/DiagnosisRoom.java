package crv.hospital.diagnoses.logic;


import crv.hospital.diagnoses.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {
    private final DoctorExamines doctorExamines;
    public DiagnosisRoom(DoctorExamines doctorExamines) {
        this.doctorExamines = doctorExamines;
    }

    public Patient diagnose(Patient patient) {
        doctorExamines.diagnose(patient); // setting the diagnose
        System.out.println("Patient: "+ patient.getName() + "; symptoms: " + patient.getSymptoms() +  "; diagnosed with " + patient.getDiagnosis());
        return patient;
    }
}
