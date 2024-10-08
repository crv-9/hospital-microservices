package crv.hospital.treatments.logic;


import crv.hospital.treatments.communication.clients.AccountancyClient;
import crv.hospital.treatments.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class NurseCare {
    private final TreatmentService treatmentService;
    private final AccountancyClient accountancyClient;

    public NurseCare(TreatmentService treatmentService, AccountancyClient accountancyClient) {
        this.treatmentService = treatmentService;
        this.accountancyClient = accountancyClient;
    }

    // provide patient with treatment
    public void handlePatient(Patient patient) {
        addTreatment(patient);
        treatmentService.saveTreatment(patient);

        accountancyClient.sendToBeInvoiced(patient); // sending Patient to be invoiced
    }

    // Later on, the exercise could be extended so that depending on the specific diagnosis of the incoming patient, a predefined treatment is provided.
    private void addTreatment(Patient patient) {
        patient.setTreatment("spend one day in the hospital bed");
    }



}
