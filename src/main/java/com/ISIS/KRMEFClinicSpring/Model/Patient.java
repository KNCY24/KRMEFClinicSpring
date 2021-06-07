package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpatient;
    private String name;
    private String sexe;
    private Date date;
    private String birthlocation;
    private String phone;
    private String address;
    private double weight;
    private double height;
    private String occupation;
    private String category;
    private String remarks;

    @OneToOne(targetEntity = Allergy.class,cascade = CascadeType.ALL)
    private Allergy allergy;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Charge> charges;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Consultation> consultations;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Dependant> dependants;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Family> families;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<History> histories;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Pathology> pathologies;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Resource> resources;
    @OneToOne(targetEntity = Situation.class,cascade = CascadeType.ALL)
    private Situation situation;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Emergency> emergencies;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Treatment> treatments;

    private int iduser;

    public Patient() {
    }

    public Patient(int idpatient, String name, String sexe, Date date, String birthlocation, String phone, String address, String occupation, String category, String remarks, Allergy allergy, Collection<Charge> charges, Collection<Consultation> consultations, Collection<Dependant> dependants, Collection<Family> families, Collection<History> histories, Collection<Pathology> pathologies, Collection<Resource> resources, Situation situation, Collection<Emergency> emergencies, Collection<Treatment> treatments, int iduser) {
        this.idpatient = idpatient;
        this.name = name;
        this.sexe = sexe;
        this.date = date;
        this.birthlocation = birthlocation;
        this.phone = phone;
        this.address = address;
        this.occupation = occupation;
        this.category = category;
        this.remarks = remarks;
        this.allergy = allergy;
        this.charges = charges;
        this.consultations = consultations;
        this.dependants = dependants;
        this.families = families;
        this.histories = histories;
        this.pathologies = pathologies;
        this.resources = resources;
        this.situation = situation;
        this.emergencies = emergencies;
        this.treatments = treatments;
        this.iduser = iduser;
    }

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

    public String getBirthlocation() {
        return birthlocation;
    }

    public void setBirthlocation(String birthlocation) {
        this.birthlocation = birthlocation;
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

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    public Collection<Charge> getCharges() {
        return charges;
    }

    public void setCharges(Collection<Charge> charges) {
        this.charges = charges;
    }

    public Collection<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(Collection<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Collection<Dependant> getDependants() {
        return dependants;
    }

    public void setDependants(Collection<Dependant> dependants) {
        this.dependants = dependants;
    }

    public Collection<Family> getFamilies() {
        return families;
    }

    public void setFamilies(Collection<Family> families) {
        this.families = families;
    }

    public Collection<History> getHistories() {
        return histories;
    }

    public void setHistories(Collection<History> histories) {
        this.histories = histories;
    }

    public Collection<Pathology> getPathologies() {
        return pathologies;
    }

    public void setPathologies(Collection<Pathology> pathologies) {
        this.pathologies = pathologies;
    }

    public Collection<Resource> getResources() {
        return resources;
    }

    public void setResources(Collection<Resource> resources) {
        this.resources = resources;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public Collection<Emergency> getEmergencies() {
        return emergencies;
    }

    public void setEmergencies(Collection<Emergency> emergencies) {
        this.emergencies = emergencies;
    }

    public Collection<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Collection<Treatment> treatments) {
        this.treatments = treatments;
    }
}
