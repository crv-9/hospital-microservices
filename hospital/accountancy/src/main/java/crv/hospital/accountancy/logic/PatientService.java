package crv.hospital.accountancy.logic;


import crv.hospital.accountancy.model.Invoice;
import crv.hospital.accountancy.model.Patient;
import crv.hospital.accountancy.model.PatientDTO;
import crv.hospital.accountancy.repository.InvoiceRepository;
import crv.hospital.accountancy.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final InvoiceRepository invoiceRepository;
    private final DTOTranslator dtoTranslator;

    public PatientService(PatientRepository patientRepository, InvoiceRepository invoiceRepository, DTOTranslator dtoTranslator) {
        this.patientRepository = patientRepository;
        this.invoiceRepository = invoiceRepository;
        this.dtoTranslator = dtoTranslator;
    }

    //Finds the Patient by uuid or saves a new one if it didn’t exist;
    // then generates an Invoice for that Patient, saves the Invoice, and returns the PatientDTO.

    public PatientDTO invoicePatient(PatientDTO patientDTO) {
        Optional<Patient> oPatient = patientRepository.findOneByUuid(patientDTO.getUuid());

        if (oPatient.isPresent()) {

            generateInvoice(oPatient.get());
            System.out.println("invoice existing patient");
            return patientDTO;
        } else {
            Patient newPatient = createNewPatient(patientDTO);

            generateInvoice(newPatient);
            System.out.println("invoice newly created patient");
            return patientDTO;
            }
    }

    private void generateInvoice(Patient patient){
        invoiceRepository.save(new Invoice(90.00, patient));
    }

    private Patient createNewPatient(PatientDTO patientDTO) {
        Patient newPatient = dtoTranslator.translateDTOToPatient(patientDTO);
        patientRepository.save(newPatient);
        return newPatient;
    }


}
