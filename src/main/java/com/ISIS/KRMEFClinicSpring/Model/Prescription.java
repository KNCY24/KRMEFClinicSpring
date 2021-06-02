package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idprescription;
    private String typeprescription;
    private String details;
    private String remarks;

    public Prescription() {
    }

    public Prescription(int idprescription, String typeprescription, String details, String remarks) {
        this.idprescription = idprescription;
        this.typeprescription = typeprescription;
        this.details = details;
        this.remarks = remarks;
    }

    public int getIdprescription() {
        return idprescription;
    }

    public void setIdprescription(int idprescription) {
        this.idprescription = idprescription;
    }

    public String getTypeprescription() {
        return typeprescription;
    }

    public void setTypeprescription(String typeprescription) {
        this.typeprescription = typeprescription;
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
