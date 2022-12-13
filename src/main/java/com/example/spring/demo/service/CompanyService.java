package com.example.spring.demo.service;

import com.example.spring.demo.model.Company;
import com.example.spring.demo.model.CompanyEmployee;
import com.example.spring.demo.model.Employee;
import com.example.spring.demo.repository.CompanyEmployeeRepository;
import com.example.spring.demo.repository.CompanyRepository;
import com.example.spring.demo.service.dto.CompanyDTO;
import com.example.spring.demo.service.dto.CompanyExtendedDTO;
import com.example.spring.demo.service.mapper.CompanyMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CompanyService {
    private CompanyRepository companyRepository;
    private CompanyEmployeeRepository companyEmployeeRepository;
    //company Mapper
    private CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyEmployeeRepository companyEmployeeRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.companyEmployeeRepository = companyEmployeeRepository;
        this.companyMapper = companyMapper;
    }

    //methods

    /**
     *
     * @param companyDTO
     * @return
     */
    public Company saveCompany(CompanyDTO companyDTO) {
        Company company = companyMapper.toEntity(companyDTO);
        return companyRepository.save(company);
    }

    public List<String> getByAfm(String cAfm) {
        List<String> companyName = companyRepository.getNameByAfm(cAfm);
        if (companyName.isEmpty()) {
            log.info("DEN YPARXEI ETAIREIA ME AUTO TO AFM PSULE");
        }
        return companyName;
    }

    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        Optional<Company> companyById = companyRepository.findById((long) companyDTO.getId());
        if (companyById.isEmpty()) {
            throw new IllegalStateException("Den yparxei tetoia etaireia vre gkasma!");
        } else {
            Company company = companyMapper.toEntity(companyDTO);
            companyRepository.save(company);
        }
        return companyDTO;
    }


    public CompanyExtendedDTO createCompany(CompanyExtendedDTO companyExtendedDTO) {

        CompanyDTO companyDTO = companyExtendedDTO.getCompanyDTO();

        Company company = companyMapper.toEntity(companyDTO);

        //assign saved company to a new company entity , so I can have access to
        // its created id to proceed with my next save (Company Employee)
        Company newCompany = companyRepository.save(company);

        createCompanyEmployee(newCompany, companyExtendedDTO);
        return companyExtendedDTO;
    }


    public CompanyExtendedDTO createCompanyEmployee(Company company, CompanyExtendedDTO companyExtendedDTO) {

        List<Employee> employeeList = companyExtendedDTO.getEmployeeList();

        List<CompanyEmployee> companyEmployeeList = new ArrayList<>();

        for (Employee employee : employeeList) {
            CompanyEmployee companyEmployee = new CompanyEmployee();
            companyEmployee.setCompany(company);
            companyEmployee.setEmployee(employee);

            companyEmployeeList.add(companyEmployee);
        }
        companyEmployeeRepository.saveAll(companyEmployeeList);
        return companyExtendedDTO;
    }
}
