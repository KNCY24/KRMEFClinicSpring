package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Dependant")
public class Dependant {
    private int iddependant;
    private String relationship;
    private String sexe;
    private int age;
    private String occupation;
    private String remarks;

    private int idsituation;
    private int idpatient;

    public Dependant() {
    }

    public Dependant(int iddependant, String relationship, String sexe, int age, String occupation, String remarks, int idsituation, int idpatient) {
        this.iddependant = iddependant;
        this.relationship = relationship;
        this.sexe = sexe;
        this.age = age;
        this.occupation = occupation;
        this.remarks = remarks;
        this.idsituation = idsituation;
        this.idpatient = idpatient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIddependant() {
        return iddependant;
    }

    public void setIddependant(int iddependant) {
        this.iddependant = iddependant;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getIdsituation() {
        return idsituation;
    }

    public void setIdsituation(int idsituation) {
        this.idsituation = idsituation;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }
}
