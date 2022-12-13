package com.example.spring.demo.service.dto;


import com.example.spring.demo.model.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class CompanyDTO {
    private Long id;
    private String cName;
    private String cAfm;
    private Date cYear;
    private String cPhone;

    //constructor
    public CompanyDTO(Company company) {
        this.setId(company.getId());
        this.setCName(company.getcName());
        this.setCAfm(company.getcAfm());
        this.setCYear(company.getcYear());
        this.setCPhone(company.getcPhone());
    }
}
