package io.everyonecodes.w1springbeans.drhouseadmission.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UUIDProvider {

    // <name, uuid>
    Map<String, String> cache = new HashMap<>();

    public UUIDProvider(Map<String, String> cache) {
        this.cache = cache;
    }

    @Bean
    Map<String, String> cache(){
        return cache;
    }

    public void setCache(Map<String, String> cache) {
        this.cache = cache;
    }

    // instructions not clear on what to return, the String or Patient
    // TODO look into this method later to make it shorter
    public String provideUUID(Patient patient){

        if (cache.containsKey(patient.getName())){
            return cache.get(patient.getName());
        } else
                cache.put(patient.getName(), UUID.randomUUID().toString());
            return cache.get(patient.getName());
    }

    public Map<String, String> getCacheSnapshot() {
        return cache;
    }

    // for this specific case just returning null and not an Optional<String>
    public String findUUID(String name){
        return cache.getOrDefault(name, null);
    }






}
