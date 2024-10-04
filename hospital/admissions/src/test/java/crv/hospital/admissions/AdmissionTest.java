package io.everyonecodes.w1springbeans.drhouseadmission;

import io.everyonecodes.w1springbeans.drhouseadmission.model.Admission;
import io.everyonecodes.w1springbeans.drhouseadmission.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
public class AdmissionTest {

    @Autowired
    Admission admission;

    @Test
    public void testAdmission() {
        Patient result = admission.admit(new Patient("carlos"));

        System.out.println(result.getName());
        System.out.println(result.getUuid());
    }
}
