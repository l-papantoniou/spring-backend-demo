package com.example.spring.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class  Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    private String eFirstName;

    @Column(name = "lastname")
    private String eLastName;

    @Column(name = "birthdate")
    private Date eBirthDate;

    @Column(name = "afm")
    private String eAfm;

    @Column(name = "sex")
    private String eSex;

    @Column(name = "nationality")
    private String eNationality;


    public String getEFirstName() {
        return eFirstName;
    }

    public void setEFirstName(String firstname) {
        this.eFirstName = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getELastName() {
        return eLastName;
    }

    public String getESex() {
        return eSex;
    }

    public void setESex(String sex) {
        this.eSex = sex;
    }

    public String getEAfm() {
        return eAfm;
    }

    public void setEAfm(String afm)  {
        this.eAfm = afm;
    }

    public Date getEBirthDate() {
        return eBirthDate;
    }

    public void setEBirthDate(Date birthdate) {
        this.eBirthDate = birthdate;
    }

    public void setELastName(String lastname) {
        this.eLastName = lastname;
    }

    public String getENationality() {
        return eNationality;
    }

    public void setENationality(String nationality) {
        this.eNationality = nationality;
    }
}
