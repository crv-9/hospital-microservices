package crv.hospital.admissions;


import crv.hospital.admissions.communication.clients.DiagnosesClient;
import crv.hospital.admissions.logic.Admission;
import crv.hospital.admissions.model.Patient;
import crv.hospital.admissions.model.UUIDProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AdmissionTest {


    @Mock
    private UUIDProvider uuidProvider;

    @Mock
    private DiagnosesClient diagnosesClient;

    @InjectMocks
    private Admission admission;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdmitPatient() {
        // Arrange
        Patient inputPatient = new Patient(null, "John Doe", "fever");
        Patient expectedPatient = new Patient("some-uuid", "John Doe", "fever");

        when(uuidProvider.provideUUID(inputPatient)).thenReturn("some-uuid");
        when(admission.admit(inputPatient)).thenReturn(expectedPatient);

        // Act
        Patient admittedPatient = admission.admit(inputPatient);



        // Assert
        assertNotNull(admittedPatient);
        assertEquals(expectedPatient.getUuid(), admittedPatient.getUuid());
        assertEquals(expectedPatient.getName(), admittedPatient.getName());
        assertEquals(expectedPatient.getSymptoms(), admittedPatient.getSymptoms());

        verify(diagnosesClient, times(1)).send(inputPatient);
        verify(uuidProvider, times(1)).provideUUID(inputPatient);
    }
}
