package crv.hospital.diagnoses.logic;


import crv.hospital.diagnoses.config.DiagnosisConfiguration;
import crv.hospital.diagnoses.model.Diagnosis;
import crv.hospital.diagnoses.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorExamines {
    private final List<Diagnosis> diagnoses;

    public DoctorExamines(DiagnosisConfiguration diagnosisConfiguration) {
        this.diagnoses = diagnosisConfiguration.getDiagnoses();
    }

    public void diagnose(Patient patient) {
        Optional<Diagnosis> oDiagnosis = diagnoses.stream()
                .filter(diagnosis -> diagnosis.getSymptoms().equals(patient.getSymptoms()))
                .findFirst();
        if (oDiagnosis.isPresent()){
            patient.setDiagnosis(oDiagnosis.get().getName());
        } else patient.setDiagnosis("Lupus");
    }
}
