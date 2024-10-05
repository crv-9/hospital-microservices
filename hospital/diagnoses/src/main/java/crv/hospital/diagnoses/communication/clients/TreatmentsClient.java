package crv.hospital.diagnoses.communication.clients;

import crv.hospital.diagnoses.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TreatmentsClient {
    private final RestTemplate restTemplate;
    private final String url;

    public TreatmentsClient(RestTemplate restTemplate, @Value("${hospital.treatments-url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    // here I am sending the Patient to be treated and receiving the treated Patient
    public Patient sendToBeTreated(Patient patient) {
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}
