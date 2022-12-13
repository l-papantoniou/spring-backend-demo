package com.example.spring.demo.service.dto;

import com.example.spring.demo.model.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    private String eFirstName;
    private String eLastName;
    private String eAfm;
    private Date eBirthDate;
    private String eSex;
    private String eNationality;

    //constructor
    public EmployeeDTO(Employee employee) {
        this.setId(employee.getId());
        this.setEFirstName(employee.getEFirstName());
        this.setELastName(employee.getELastName());
        this.setEAfm(employee.getEAfm());
        this.setEBirthDate(employee.getEBirthDate());
        this.setESex(employee.getESex());
        this.setENationality(employee.getENationality());
    }
}


