package crv.hospital.admissions.communication.controllers.controllers;


import crv.hospital.admissions.model.UUIDProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/uuids")
public class UUIDCacheEndpoint {
    //The ResponseEntity class allows to create responses with different HTTP status codes --> good practice in REST APIs.
    private final UUIDProvider uuidProvider;
    public UUIDCacheEndpoint(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getCache() {
        return ResponseEntity.ok(uuidProvider.getCacheSnapshot());
    }

    @GetMapping("/{patientName}")
    public ResponseEntity<String> getPatient(@PathVariable String patientName) {
        return uuidProvider.findUUID(patientName)
                .map(uuid -> ResponseEntity.ok(uuid))  // If UUID found, return 200 OK with the UUID
                .orElseGet(() -> ResponseEntity.notFound().build());  // If not found, return 404
    }
}
