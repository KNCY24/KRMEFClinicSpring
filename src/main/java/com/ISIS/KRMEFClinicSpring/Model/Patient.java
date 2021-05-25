package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Patient")
public class Patient {
    private int idpatient;
    private String name;
    private String sexe;
    private Date date;
    private String phone;
    private String address;
    private double weight;
    private double height;
    private String occupation;
    private String category;
    private String remarks;

    private int iduser;
    private int idsituation;

    public Patient() {
    }

    public Patient(int idpatient, String name, String sexe, Date date, String phone, String address, double weight, double height, String occupation, String category, String remarks, int iduser, int idsituation) {
        this.idpatient = idpatient;
        this.name = name;
        this.sexe = sexe;
        this.date = date;
        this.phone = phone;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.occupation = occupation;
        this.category = category;
        this.remarks = remarks;
        this.iduser = iduser;
        this.idsituation = idsituation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public int getIdsituation() {
        return idsituation;
    }

    public void setIdsituation(int idsituation) {
        this.idsituation = idsituation;
    }
}
