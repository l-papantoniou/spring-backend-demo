package com.example.spring.demo.service;


import com.example.spring.demo.model.CompanyEmployee;
import com.example.spring.demo.repository.CompanyEmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CompanyEmployeeService {

    private CompanyEmployeeRepository companyEmployeeRepository;

    //constructor
    public CompanyEmployeeService(CompanyEmployeeRepository companyEmployeeRepository) {
        this.companyEmployeeRepository = companyEmployeeRepository;
    }

    //methods
    public CompanyEmployee saveCompanyEmployee(CompanyEmployee companyEmployee) {
        return companyEmployeeRepository.save(companyEmployee);
    }
}
