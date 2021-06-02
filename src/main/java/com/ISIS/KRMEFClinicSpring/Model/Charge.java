package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Charge")
public class Charge {
    private int idcharge;
    private String name;
    private double amount;
    private String duration;
    private int frequency;

    private int idpatient;

    public Charge() {
    }

    public Charge(int idcharge, String name, double amount, String duration, int frequency, int idpatient) {
        this.idcharge = idcharge;
        this.name = name;
        this.amount = amount;
        this.duration = duration;
        this.frequency = frequency;
        this.idpatient = idpatient;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdcharge() {
        return idcharge;
    }

    public void setIdcharge(int idcharge) {
        this.idcharge = idcharge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }
}
