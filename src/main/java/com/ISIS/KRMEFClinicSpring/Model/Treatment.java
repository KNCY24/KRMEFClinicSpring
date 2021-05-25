package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Treatment")
public class Treatment {
    private int idtreatment;
    private String name;
    private Date start;
    private Date deadline;
    private String duration;
    private int frequency;
    private String quantity;
    private String remarks;

    private int idpathology;

    public Treatment() {
    }

    public Treatment(int idtreatment, String name, Date start, Date deadline, String duration, int frequency, String quantity, String remarks, int idpathology) {
        this.idtreatment = idtreatment;
        this.name = name;
        this.start = start;
        this.deadline = deadline;
        this.duration = duration;
        this.frequency = frequency;
        this.quantity = quantity;
        this.remarks = remarks;
        this.idpathology = idpathology;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdtreatment() {
        return idtreatment;
    }

    public void setIdtreatment(int idtreatment) {
        this.idtreatment = idtreatment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getIdpathology() {
        return idpathology;
    }

    public void setIdpathology(int idpathology) {
        this.idpathology = idpathology;
    }
}
