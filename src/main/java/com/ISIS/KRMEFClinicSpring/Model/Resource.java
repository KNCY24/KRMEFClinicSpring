package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Resource")
public class Resource {
    private int idresource;
    private String source;
    private double amount;
    private String duration;
    private int frequency;

    private int idpatient;

    public Resource() {
    }

    public Resource(int idresource, String source, double amount, String duration, int frequency, int idpatient) {
        this.idresource = idresource;
        this.source = source;
        this.amount = amount;
        this.duration = duration;
        this.frequency = frequency;
        this.idpatient = idpatient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdresource() {
        return idresource;
    }

    public void setIdresource(int idresource) {
        this.idresource = idresource;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
