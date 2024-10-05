package crv.hospital.admissions.clients;


import crv.hospital.admissions.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class DiagnosesClient {
    private final RestTemplate restTemplate;
    private final String url;

    public DiagnosesClient(RestTemplate restTemplate, @Value("${hospital.diagnoses-url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public void send(Patient patient) {
        try {
            restTemplate.postForObject(url, patient, Patient.class);
        } catch (HttpClientErrorException.Unauthorized e) {
            // Handles 401 Unauthorized error
            System.out.println("Unauthorized access - check credentials: " + e.getMessage());
            // throws a custom exception
        } catch (Exception e) {
            // Handle any other errors
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
