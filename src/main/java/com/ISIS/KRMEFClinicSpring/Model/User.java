package com.ISIS.KRMEFClinicSpring.Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "User")
public class User {
    private int iduser;
    private String name;
    private String role;
    private Date date;
    private String sexe;
    private String username;
    private String password;

    public User() {
    }

    public User(int iduser, String name, String role,Date date, String sexe, String username, String password) {
        this.iduser = iduser;
        this.name = name;
        this.role = role;
        this.date = date;
        this.sexe = sexe;
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
