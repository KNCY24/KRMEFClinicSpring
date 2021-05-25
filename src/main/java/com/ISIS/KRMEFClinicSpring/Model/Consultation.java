package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Consultation")
public class Consultation {
    private int idconsultation;
    private String issue;
    private Date date;
    private String remarks;

    private int iduser;
    private int idpatient;

    public Consultation() {
    }

    public Consultation(int idconsultation, String issue, Date date, String remarks, int iduser, int idpatient) {
        this.idconsultation = idconsultation;
        this.issue = issue;
        this.date = date;
        this.remarks = remarks;
        this.iduser = iduser;
        this.idpatient = idpatient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdconsultation() {
        return idconsultation;
    }

    public void setIdconsultation(int idconsultation) {
        this.idconsultation = idconsultation;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }
}
