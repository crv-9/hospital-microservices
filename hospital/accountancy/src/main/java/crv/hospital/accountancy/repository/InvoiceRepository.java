package crv.hospital.accountancy.repository;


import crv.hospital.accountancy.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
