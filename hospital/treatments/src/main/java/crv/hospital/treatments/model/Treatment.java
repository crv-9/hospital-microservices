package crv.hospital.treatments.model;

import java.util.Objects;

public class Treatment {
    String id;
    String uuid;
    String name;
    String symptoms;
    String diagnosis;
    String treatment;

    public Treatment() {
    }

    public Treatment(String uuid, String name, String symptoms, String diagnosis, String treatment) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public Treatment(String id, String uuid, String name, String symptoms, String diagnosis, String treatment) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Treatment treatment1)) return false;
        return Objects.equals(id, treatment1.id) && Objects.equals(uuid, treatment1.uuid) && Objects.equals(name, treatment1.name) && Objects.equals(symptoms, treatment1.symptoms) && Objects.equals(diagnosis, treatment1.diagnosis) && Objects.equals(treatment, treatment1.treatment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid, name, symptoms, diagnosis, treatment);
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "id='" + id + '\'' +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}

