package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idhistory;
    private String relationship;
    private String disease;


    public History() {
    }

    public History(int idhistory, String relationship, String disease) {
        this.idhistory = idhistory;
        this.relationship = relationship;
        this.disease = disease;
    }

    public int getIdhistory() {
        return idhistory;
    }

    public void setIdhistory(int idhistory) {
        this.idhistory = idhistory;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

}
