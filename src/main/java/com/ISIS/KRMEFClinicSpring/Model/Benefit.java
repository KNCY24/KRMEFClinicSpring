package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Benefit")
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbenefit;
    private Date date;
    private String packaging;
    private int quantity;
    private double price;
    private double due;

    private int idpatient;
    private int idmedicine;

    @OneToOne(targetEntity = DetailStock.class,cascade = CascadeType.ALL)
    private DetailStock detailstock;

    public Benefit() {
    }

    public Benefit(int idbenefit, Date date, String packaging, int quantity, double price, double due, int idpatient, int idmedicine, DetailStock detailstock) {
        this.idbenefit = idbenefit;
        this.date = date;
        this.packaging = packaging;
        this.quantity = quantity;
        this.price = price;
        this.due = due;
        this.idpatient = idpatient;
        this.idmedicine = idmedicine;
        this.detailstock = detailstock;
    }

    public int getIdbenefit() {
        return idbenefit;
    }

    public void setIdbenefit(int idbenefit) {
        this.idbenefit = idbenefit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public int getIdmedicine() {
        return idmedicine;
    }

    public void setIdmedicine(int idmedicine) {
        this.idmedicine = idmedicine;
    }

    public DetailStock getdetailstock() {
        return detailstock;
    }

    public void setdetailstock(DetailStock detailstock) {
        this.detailstock = detailstock;
    }
}
