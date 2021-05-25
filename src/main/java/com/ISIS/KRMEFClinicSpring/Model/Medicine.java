package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Medicine")
public class Medicine {
    private int idmedicine;
    private String name;
    private String packaging;
    private int quantity;
    private Date expiration;
    private double retailprice;

    private int iddetailstock;

    public Medicine() {
    }

    public Medicine(int idmedicine, String name, String packaging, int quantity, Date expiration, double retailprice, int iddetailstock) {
        this.idmedicine = idmedicine;
        this.name = name;
        this.packaging = packaging;
        this.quantity = quantity;
        this.expiration = expiration;
        this.retailprice = retailprice;
        this.iddetailstock = iddetailstock;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdmedicine() {
        return idmedicine;
    }

    public void setIdmedicine(int idmedicine) {
        this.idmedicine = idmedicine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public double getRetailprice() {
        return retailprice;
    }

    public void setRetailprice(double retailprice) {
        this.retailprice = retailprice;
    }

    public int getIddetailstock() {
        return iddetailstock;
    }

    public void setIddetailstock(int iddetailstock) {
        this.iddetailstock = iddetailstock;
    }
}
