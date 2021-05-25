package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Emergency")
public class Emergency {
    private int idemergency;
    private String name;
    private String relationship;
    private String phone;
    private String remarks;

    private int idpatient;

    public Emergency() {
    }

    public Emergency(int idemergency, String name, String relationship, String phone, String remarks, int idpatient) {
        this.idemergency = idemergency;
        this.name = name;
        this.relationship = relationship;
        this.phone = phone;
        this.remarks = remarks;
        this.idpatient = idpatient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdemergency() {
        return idemergency;
    }

    public void setIdemergency(int idemergency) {
        this.idemergency = idemergency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
