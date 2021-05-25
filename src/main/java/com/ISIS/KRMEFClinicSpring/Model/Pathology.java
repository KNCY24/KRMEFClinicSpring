package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Pathology")
public class Pathology {
    private int idpathology;
    private String name;

    private int idpatient;

    public Pathology() {
    }

    public Pathology(int idpathology, String name, int idpatient) {
        this.idpathology = idpathology;
        this.name = name;
        this.idpatient = idpatient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdpathology() {
        return idpathology;
    }

    public void setIdpathology(int idpathology) {
        this.idpathology = idpathology;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }
}
