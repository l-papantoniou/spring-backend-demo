package com.example.spring.demo.controller;

import com.example.spring.demo.model.Company;
import com.example.spring.demo.service.CompanyService;
import com.example.spring.demo.service.dto.CompanyDTO;
import com.example.spring.demo.service.dto.CompanyExtendedDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class  CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {

        this.companyService = companyService;
    }


    //REST API
    @PostMapping("/company")
    public Company saveCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.saveCompany(companyDTO);
    }

    @PostMapping("/companyemployees")
    public CompanyExtendedDTO createCompany(@RequestBody CompanyExtendedDTO companyExtendedDTO) {
        return companyService.createCompany(companyExtendedDTO);
    }

    @GetMapping("/company/{afm}")
    public List<String> getCompanyByAfm(@PathVariable String afm) {
        return companyService.getByAfm(afm);

    }

    @PutMapping("/company")
    public CompanyDTO updateCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.updateCompany(companyDTO);
    }

}
