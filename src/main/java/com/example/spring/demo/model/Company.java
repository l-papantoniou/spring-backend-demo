package com.example.spring.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "company")
public class  Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String cName;

    @Column(name="company_afm")
    private String cAfm;

    @Column(name="establishment_year")
    private Date cYear;

    @Column(name="phone")
    private String cPhone;


// class methods
    public Long getId() {
        return id;
    }

    public String getcName() {
        return cName;
    }

    public String getcAfm() {
        return cAfm;
    }

    public Date getcYear() {
        return cYear;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setcAfm(String cAfm) {
        this.cAfm = cAfm;
    }

    public void setcYear(Date cYear) {
        this.cYear = cYear;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }
}


