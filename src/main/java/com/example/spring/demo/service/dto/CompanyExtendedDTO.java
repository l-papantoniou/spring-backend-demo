package com.example.spring.demo.service.dto;

import com.example.spring.demo.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.util.List;

@Data
@Jacksonized
public class CompanyExtendedDTO extends CompanyDTO implements Serializable {

    @JsonProperty("employees")
    private List<Employee> employeeList;

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.setId(companyDTO.getId());
        this.setCName(companyDTO.getCName());
        this.setCAfm(companyDTO.getCAfm());
        this.setCYear(companyDTO.getCYear());
        this.setCPhone(companyDTO.getCPhone());
    }

    @JsonIgnore
    public CompanyDTO getCompanyDTO() {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(this.getId());
        companyDTO.setCName(this.getCName());
        companyDTO.setCAfm(this.getCAfm());
        companyDTO.setCYear(this.getCYear());
        companyDTO.setCPhone(this.getCPhone());

        return companyDTO;
    }

}
