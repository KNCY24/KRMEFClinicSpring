package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.*;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

public class Clinic {
    @OneToMany
    private Collection<Benefit> benefits;
    @OneToMany
    private Collection<Expense> expenses;
    @OneToMany
    private Collection<Medicine> medicines;
    @OneToMany
    private Collection<Inventory> inventories;
    @OneToMany
    private Collection<Patient> patients;
    @OneToMany
    private Collection<User> users;

    public Clinic() {
    }

    public Collection<Benefit> getBenefits() {
        return benefits;
    }

    public void setBenefits(Collection<Benefit> benefits) {
        this.benefits = benefits;
    }

    public Collection<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Collection<Expense> expenses) {
        this.expenses = expenses;
    }


    public Collection<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(Collection<Medicine> medicines) {
        this.medicines = medicines;
    }

    public Collection<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Collection<Inventory> inventories) {
        this.inventories = inventories;
    }


    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Collection<Patient> patients) {
        this.patients = patients;
    }
}
