package io.everyonecodes.w1springbeans.drhouseadmission.controllers;

import io.everyonecodes.w1springbeans.drhouseadmission.model.UUIDProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/uuids")
public class UUIDCacheEndpoint {

    UUIDProvider uuidProvider;
    public UUIDCacheEndpoint(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    @GetMapping
    public Map<String, String> getCache() {
        return uuidProvider.getCacheSnapshot();
    }

    @GetMapping("/{patientName}")
    public String getPatient(@PathVariable String patientName) {

        return uuidProvider.findUUID(patientName);
    }
}
