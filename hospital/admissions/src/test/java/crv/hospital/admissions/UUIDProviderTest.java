package crv.hospital.admissions;


import crv.hospital.admissions.model.Patient;
import crv.hospital.admissions.model.UUIDProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UUIDProviderTest {

    @Autowired
    private UUIDProvider uuidProvider;

    @Test
    public void provideUUIDNoPreviousUUID() {
        String result = uuidProvider.provideUUID(new Patient("carlos"));
        System.out.println(result);
    }

    @Test
    public void provideUUIDPreviousUUID() {
        Patient patient = new Patient("carlos");
        Patient patient2 = new Patient("carlosR");
        String result = uuidProvider.provideUUID(patient);
        String result2 = uuidProvider.provideUUID(patient);
        String resultp2 = uuidProvider.provideUUID(patient2);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(resultp2);

        System.out.println(uuidProvider.getCacheSnapshot());
    }

    @Test
    public void findUUID(){
        Patient patient = new Patient("carlos");
        Patient patient2 = new Patient("carlosR");
        String result = uuidProvider.provideUUID(patient);
        String result2 = uuidProvider.provideUUID(patient);
        String resultp2 = uuidProvider.provideUUID(patient2);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(resultp2);

        System.out.println("uuid: " +  uuidProvider.findUUID("carlosR"));
    }
    @Test
    public void findUUIDEmpty(){
        Patient patient = new Patient("carlos");
        Patient patient2 = new Patient("carlosR");
        String result = uuidProvider.provideUUID(patient);
        String result2 = uuidProvider.provideUUID(patient);
        String resultp2 = uuidProvider.provideUUID(patient2);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(resultp2);

        System.out.println("uuid: " +  uuidProvider.findUUID("cR"));
    }




}
