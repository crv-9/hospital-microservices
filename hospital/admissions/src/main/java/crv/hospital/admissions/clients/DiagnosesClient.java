package io.everyonecodes.w1springbeans.drhouseadmission.clients;

import io.everyonecodes.w1springbeans.drhouseadmission.model.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class DiagnosesClient {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:9002/patients";

    public DiagnosesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Patient send(Patient patient){
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}
