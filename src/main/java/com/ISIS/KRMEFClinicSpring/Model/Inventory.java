package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Inventory")
public class Inventory {
    private int idinventory;
    private String name;
    private String source;

    public Inventory() {
    }

    public Inventory(int idinventory, String name,String source) {
        this.idinventory = idinventory;
        this.name = name;
        this.source = source;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdinventory() {
        return idinventory;
    }

    public void setIdinventory(int idinventory) {
        this.idinventory = idinventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
