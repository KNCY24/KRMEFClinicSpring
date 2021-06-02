package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddiagnosis;
    private String classification;
    private String details;
    private String remarks;


    public Diagnosis() {
    }

    public Diagnosis(int iddiagnosis, String classification, String details, String remarks) {
        this.iddiagnosis = iddiagnosis;
        this.classification = classification;
        this.details = details;
        this.remarks = remarks;
    }

    public int getIddiagnosis() {
        return iddiagnosis;
    }

    public void setIddiagnosis(int iddiagnosis) {
        this.iddiagnosis = iddiagnosis;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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
