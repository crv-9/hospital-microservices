package crv.hospital.accountancy.logic;


import crv.hospital.accountancy.model.Patient;
import crv.hospital.accountancy.model.PatientDTO;
import org.springframework.stereotype.Service;

@Service
public class DTOTranslator {

    public Patient translateDTOToPatient(PatientDTO patientDTO){
    // TODO add translation logic
        return new Patient(
                patientDTO.getUuid(),
                patientDTO.getName(),
                patientDTO.getSymptoms(),
                patientDTO.getDiagnosis(),
                patientDTO.getTreatment()
        );
    }

    public void translatePatientToDTO(){
        // TODO add translation logic
    }

}
