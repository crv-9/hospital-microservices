package crv.hospital.admissions.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public Optional<String> findUUID(String name){
        return Optional.ofNullable(cache.get(name));
    }

}
