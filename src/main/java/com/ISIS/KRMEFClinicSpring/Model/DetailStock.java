package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Detailstock")
public class DetailStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddetailstock;
    private String packaging;
    private int quantity;
    private double more;

    public DetailStock() {
    }

    public DetailStock(int iddetailstock, String packaging, int quantity, double more) {
        this.iddetailstock = iddetailstock;
        this.packaging = packaging;
        this.quantity = quantity;
        this.more = more;
    }

    public int getIddetailstock() {
        return iddetailstock;
    }

    public void setIddetailstock(int iddetailstock) {
        this.iddetailstock = iddetailstock;
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

    public double getMore() {
        return more;
    }

    public void setMore(double more) {
        this.more = more;
    }
}
