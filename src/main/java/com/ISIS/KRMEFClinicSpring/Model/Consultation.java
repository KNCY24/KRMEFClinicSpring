package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity(name = "Consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idconsultation;
    private String issue;
    private Date date;
    private String remarks;

    private int iduser;

    @OneToMany
    private Collection<Diagnosis> diagnoses;
    @OneToMany
    private Collection<Observation> observations;
    @OneToMany
    private Collection<Prescription> prescriptions;

    public Consultation() {
    }

    public Consultation(int idconsultation, String issue, Date date, String remarks, int iduser, Collection<Diagnosis> diagnoses, Collection<Observation> observations, Collection<Prescription> prescriptions) {
        this.idconsultation = idconsultation;
        this.issue = issue;
        this.date = date;
        this.remarks = remarks;
        this.iduser = iduser;
        this.diagnoses = diagnoses;
        this.observations = observations;
        this.prescriptions = prescriptions;
    }

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

    public Collection<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Collection<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Collection<Observation> getObservations() {
        return observations;
    }

    public void setObservations(Collection<Observation> observations) {
        this.observations = observations;
    }

    public Collection<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Collection<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
