package crv.hospital.diagnoses.model;

import java.util.Objects;

public class Diagnosis {
    String name;
    String symptoms;

    public Diagnosis() {
    }

    public Diagnosis(String name, String symptoms) {
        this.name = name;
        this.symptoms = symptoms;
    }

    // this will be used for Lupus cases where I only have unknown symptoms and need to return a diagnosis with a name = Lupus
    public Diagnosis(String name) {
        this.name = name;
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
        if (!(o instanceof Diagnosis diagnosis)) return false;
        return Objects.equals(name, diagnosis.name) && Objects.equals(symptoms, diagnosis.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symptoms);
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "name='" + name + '\'' +
                ", symptoms='" + symptoms + '\'' +
                '}';
    }
}
