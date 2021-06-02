package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Charge")
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcharge;
    private String name;
    private double amount;
    private String duration;
    private int frequency;


    public Charge() {
    }

    public Charge(int idcharge, String name, double amount, String duration, int frequency) {
        this.idcharge = idcharge;
        this.name = name;
        this.amount = amount;
        this.duration = duration;
        this.frequency = frequency;
    }


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

}
