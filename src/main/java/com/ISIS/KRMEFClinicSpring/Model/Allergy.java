package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Allergy")
public class Allergy {
    private int idallergy;
    private String name;

    private int idpatient;

    public Allergy() {
    }

    public Allergy(int idallergy, String name, int idpatient) {
        this.idallergy = idallergy;
        this.name = name;
        this.idpatient = idpatient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdallergy() {
        return idallergy;
    }

    public void setIdallergy(int idallergy) {
        this.idallergy = idallergy;
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
