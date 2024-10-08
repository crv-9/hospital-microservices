package crv.hospital.accountancy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    Long id;
    Double cost;
    boolean paid;

    @ManyToOne
    Patient patient;

    public Invoice() {
    }

    public Invoice(Double cost, Patient patient) {
        this.cost = cost;
        this.paid = false;
        this.patient = patient;
    }

    public Invoice(Double cost, boolean paid, Patient patient) {
        this.cost = cost;
        this.paid = paid;
        this.patient = patient;
    }

    public Invoice(Long id, Double cost, boolean paid, Patient patient) {
        this.id = id;
        this.cost = cost;
        this.paid = paid;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
