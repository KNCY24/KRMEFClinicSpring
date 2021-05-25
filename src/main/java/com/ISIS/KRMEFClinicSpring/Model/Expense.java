package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "Expense")
public class Expense {
    private int idexpense;
    private Date date;
    private String packaging;
    private int quantity;
    private double amount;

    private int idmedicine;
    private int iddetailstock;

    public Expense() {
    }

    public Expense(int idexpense, Date date, String packaging, int quantity, double amount, int idmedicine, int iddetailstock) {
        this.idexpense = idexpense;
        this.date = date;
        this.packaging = packaging;
        this.quantity = quantity;
        this.amount = amount;
        this.idmedicine = idmedicine;
        this.iddetailstock = iddetailstock;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public int getIdmedicine() {
        return idmedicine;
    }

    public void setIdmedicine(int idmedicine) {
        this.idmedicine = idmedicine;
    }

    public int getIddetailstock() {
        return iddetailstock;
    }

    public void setIddetailstock(int iddetailstock) {
        this.iddetailstock = iddetailstock;
    }
}
