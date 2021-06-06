package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "Pathology")
public class Pathology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpathology;
    private String type;
    private String name;

    public Pathology() {
    }

    public Pathology(int idpathology, String type, String name) {
        this.idpathology = idpathology;
        this.type = type;
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
