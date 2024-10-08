package crv.hospital.treatments.communication.clients;

import crv.hospital.treatments.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccountancyClient {
    private final RestTemplate restTemplate;
    private final String url;

    public AccountancyClient(RestTemplate restTemplate, @Value("${hospital.accountancy-url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    // here I am sending the Patient to be invoiced and receiving the invoice Patient
    public void sendToBeInvoiced(Patient patient){
        restTemplate.postForObject(url, patient, Patient.class);
    }
}
