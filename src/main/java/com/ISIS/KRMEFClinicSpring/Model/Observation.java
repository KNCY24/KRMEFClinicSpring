package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Observation")
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idobservation;
    private String name;
    private String details;
    private String remarks;


    public Observation() {
    }

    public Observation(int idobservation, String name, String details, String remarks) {
        this.idobservation = idobservation;
        this.name = name;
        this.details = details;
        this.remarks = remarks;
    }

    public int getIdobservation() {
        return idobservation;
    }

    public void setIdobservation(int idobservation) {
        this.idobservation = idobservation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
