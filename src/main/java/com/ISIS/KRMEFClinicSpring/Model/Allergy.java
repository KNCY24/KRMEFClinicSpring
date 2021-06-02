package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idallergy;
    private String name;


    public Allergy() {
    }

    public Allergy(int idallergy, String name) {
        this.idallergy = idallergy;
        this.name = name;
    }

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


}
