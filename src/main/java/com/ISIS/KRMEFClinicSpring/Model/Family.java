package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Family")
public class Family {
    private int idfamily;
    private String relationship;
    private int age;
    private String occupation;
    private String remarks;

    private int idpatient;

    public Family() {
    }

    public Family(int idfamily, String relationship, int age, String occupation, String remarks, int idpatient) {
        this.idfamily = idfamily;
        this.relationship = relationship;
        this.age = age;
        this.occupation = occupation;
        this.remarks = remarks;
        this.idpatient = idpatient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdfamily() {
        return idfamily;
    }

    public void setIdfamily(int idfamily) {
        this.idfamily = idfamily;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
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

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }
}
