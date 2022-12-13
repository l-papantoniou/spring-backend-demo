package com.example.spring.demo.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Data
@Jacksonized

public class EmployeeExtendeDTO extends EmployeeDTO implements Serializable {

    @JsonProperty("company")
    private String cName;

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.setId(employeeDTO.getId());
        this.setEFirstName(employeeDTO.getEFirstName());
        this.setELastName(employeeDTO.getELastName());
        this.setEBirthDate(employeeDTO.getEBirthDate());
        this.setEAfm(employeeDTO.getEAfm());
        this.setESex(employeeDTO.getESex());
        this.setENationality(employeeDTO.getENationality());
    }

    @JsonIgnore
    public EmployeeDTO getEmployeeDTO() {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(this.getId());
        employeeDTO.setEFirstName(this.getEFirstName());
        employeeDTO.setELastName(this.getELastName());
        employeeDTO.setEBirthDate(this.getEBirthDate());
        employeeDTO.setEAfm(this.getEAfm());
        employeeDTO.setESex(this.getESex());
        employeeDTO.setENationality(this.getENationality());

        return employeeDTO;
    }
}
