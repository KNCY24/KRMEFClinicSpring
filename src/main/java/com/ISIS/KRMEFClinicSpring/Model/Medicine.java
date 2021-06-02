package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmedicine;
    private String name;
    private String packaging;
    private int quantity;
    private Date expiration;
    private double retailprice;
    private String source;

    @OneToOne(targetEntity = DetailStock.class,cascade = CascadeType.ALL)
    private DetailStock detailstock;

    public Medicine() {
    }

    public Medicine(int idmedicine, String name, String packaging, int quantity, Date expiration, double retailprice, String source, DetailStock detailstock) {
        this.idmedicine = idmedicine;
        this.name = name;
        this.packaging = packaging;
        this.quantity = quantity;
        this.expiration = expiration;
        this.retailprice = retailprice;
        this.source = source;
        this.detailstock = detailstock;
    }

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public DetailStock getdetailstock() {
        return detailstock;
    }

    public void setdetailstock(DetailStock detailstock) {
        this.detailstock = detailstock;
    }
}
