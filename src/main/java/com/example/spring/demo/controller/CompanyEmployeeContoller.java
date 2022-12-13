package com.example.spring.demo.controller;

import com.example.spring.demo.model.CompanyEmployee;
import com.example.spring.demo.service.CompanyEmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
public class CompanyEmployeeContoller {

    private CompanyEmployeeService companyEmployeeService;

    public CompanyEmployeeContoller(CompanyEmployeeService companyEmployeeService) {
        this.companyEmployeeService = companyEmployeeService;
    }


    //REST API
    @PostMapping("/companyemployee")
    public CompanyEmployee saveCompanyEmployee(@RequestBody CompanyEmployee companyEmployee) {
        return companyEmployeeService.saveCompanyEmployee(companyEmployee);
    }
}
