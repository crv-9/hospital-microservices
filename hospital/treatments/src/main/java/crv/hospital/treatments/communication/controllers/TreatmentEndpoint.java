package crv.hospital.treatments.communication.controllers;


import crv.hospital.treatments.logic.TreatmentService;
import crv.hospital.treatments.model.Treatment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treatments")
public class TreatmentEndpoint {

    private final TreatmentService treatmentService;

    public TreatmentEndpoint(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping()
    public List<Treatment> getAllTreatments() {
        return treatmentService.getAllTreatments();
    }

    @GetMapping("/{uuid}")
    public List<Treatment> getTreatmentByUuid(@PathVariable String uuid) {
        return treatmentService.getTreatmentsByPatientUuid(uuid);
    }



}
