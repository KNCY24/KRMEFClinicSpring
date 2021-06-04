package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.*;
import java.util.Collection;
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
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Expense> achats;
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    private Collection<Benefit> ventes;

    public Medicine() {
    }

    public Medicine(int idmedicine, String name, String packaging, int quantity, Date expiration, double retailprice, String source, DetailStock detailstock, Collection<Expense> achats, Collection<Benefit> ventes) {
        this.idmedicine = idmedicine;
        this.name = name;
        this.packaging = packaging;
        this.quantity = quantity;
        this.expiration = expiration;
        this.retailprice = retailprice;
        this.source = source;
        this.detailstock = detailstock;
        this.achats = achats;
        this.ventes = ventes;
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

    public DetailStock getDetailstock() {
        return detailstock;
    }

    public void setDetailstock(DetailStock detailstock) {
        this.detailstock = detailstock;
    }

    public Collection<Expense> getAchats() {
        return achats;
    }

    public void setAchats(Collection<Expense> achats) {
        this.achats = achats;
    }

    public Collection<Benefit> getVentes() {
        return ventes;
    }

    public void setVentes(Collection<Benefit> ventes) {
        this.ventes = ventes;
    }
}
