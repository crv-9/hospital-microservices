package crv.hospital.accountancy.communication.endpoints;


import crv.hospital.accountancy.logic.InvoiceService;
import crv.hospital.accountancy.model.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class AccountancyEndpoint {
    final InvoiceService invoiceService;

    public AccountancyEndpoint(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.findAll();
    }

    @PutMapping("/{id}/paid")
    public void updatePaid(@PathVariable long id) {
        invoiceService.updateInvoice(id);
    }
}
