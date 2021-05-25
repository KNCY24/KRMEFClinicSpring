package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Detailstock")
public class DetailStock {
    private int iddetailstock;
    private String packaging;
    private int quantity;
    private String remarks;

    public DetailStock() {
    }

    public DetailStock(int iddetailstock, String packaging, int quantity, String remarks) {
        this.iddetailstock = iddetailstock;
        this.packaging = packaging;
        this.quantity = quantity;
        this.remarks = remarks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
