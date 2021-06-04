package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "Pathology")
public class Pathology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpathology;
    private String name;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Treatment> treatments;

    public Pathology() {
    }

    public Pathology(int idpathology, String name, Collection<Treatment> treatments) {
        this.idpathology = idpathology;
        this.name = name;
        this.treatments = treatments;
    }

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

    public Collection<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(Collection<Treatment> treatments) {
        this.treatments = treatments;
    }
}
