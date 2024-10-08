package crv.hospital.accountancy.repository;


import crv.hospital.accountancy.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findOneByUuid (String uuid);
}
