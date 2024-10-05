package crv.hospital.diagnoses.config;


import crv.hospital.diagnoses.model.Diagnosis;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("hospital")
public class DiagnosisConfiguration {

    private List<Diagnosis> diagnoses;

    @Bean
    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

}
