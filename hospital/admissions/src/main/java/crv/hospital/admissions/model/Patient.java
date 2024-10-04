package io.everyonecodes.w1springbeans.drhouseadmission.model;


import java.util.Objects;

public class Patient {
    String uuid;
    String name;
    String symptoms;

    public Patient() {
    }

    public Patient(String name) {
        this.name = name;
    }

    public Patient(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }



    public Patient(String uuid, String name, String symptoms) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return Objects.equals(uuid, patient.uuid) && Objects.equals(name, patient.name) && Objects.equals(symptoms, patient.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, symptoms);
    }
}
