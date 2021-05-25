package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Situation")
public class Situation {
    private int idsituation;
    private String typesituation;
    private String occupation;
    private String remarks;

    public Situation() {
    }

    public Situation(int idsituation, String typesituation, String occupation, String remarks) {
        this.idsituation = idsituation;
        this.typesituation = typesituation;
        this.occupation = occupation;
        this.remarks = remarks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdsituation() {
        return idsituation;
    }

    public void setIdsituation(int idsituation) {
        this.idsituation = idsituation;
    }

    public String getTypesituation() {
        return typesituation;
    }

    public void setTypesituation(String typesituation) {
        this.typesituation = typesituation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
