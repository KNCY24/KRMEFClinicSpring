package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idexpense;
    private Date date;
    private String packaging;
    private int quantity;
    private double amount;


    @OneToOne(targetEntity = DetailStock.class,cascade = CascadeType.ALL)
    private DetailStock detailstock;

    public Expense() {
    }

    public Expense(int idexpense, Date date, String packaging, int quantity, double amount, DetailStock detailstock) {
        this.idexpense = idexpense;
        this.date = date;
        this.packaging = packaging;
        this.quantity = quantity;
        this.amount = amount;
        this.detailstock = detailstock;
    }

    public int getIdexpense() {
        return idexpense;
    }

    public void setIdexpense(int idexpense) {
        this.idexpense = idexpense;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public DetailStock getdetailstock() {
        return detailstock;
    }

    public void setdetailstock(DetailStock detailstock) {
        this.detailstock = detailstock;
    }
}
