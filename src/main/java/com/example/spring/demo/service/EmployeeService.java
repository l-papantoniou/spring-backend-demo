package com.example.spring.demo.service;

import com.example.spring.demo.model.Company;
import com.example.spring.demo.model.CompanyEmployee;
import com.example.spring.demo.model.Employee;
import com.example.spring.demo.repository.CompanyEmployeeRepository;
import com.example.spring.demo.repository.CompanyRepository;
import com.example.spring.demo.repository.EmployeeRepository;
import com.example.spring.demo.service.dto.EmployeeDTO;
import com.example.spring.demo.service.dto.EmployeeExtendeDTO;
import com.example.spring.demo.service.mapper.EmployeeMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    private CompanyRepository companyRepository;

    private CompanyEmployeeRepository companyEmployeeRepository;

    //mapper
    public EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, CompanyRepository companyRepository, CompanyEmployeeRepository companyEmployeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.companyEmployeeRepository = companyEmployeeRepository;
        this.employeeMapper = employeeMapper;
    }

    //methods

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployee(Integer id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeeByAfm(String eAFM) {
        List<Employee> employeeName = employeeRepository.getEmployeeByAfm(eAFM);
        if (employeeName.isEmpty()) {
            log.info("Den uparxei autos o man ");
        }
        return employeeName;
    }

    public List<Employee> findAll() {
        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList;
    }

    public void deleteEmployee(Integer employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException(
                    "employee with id" + employeeId + "does not exist"
            );
        } else {
            employeeRepository.deleteById(employeeId);
        }
    }

    /**
     * @param employeeExtendeDTO
     * @return
     */
    public EmployeeExtendeDTO hireEmployee(EmployeeExtendeDTO employeeExtendeDTO) {
        List<Employee> employeeList = employeeRepository.getEmployeeByAfm(employeeExtendeDTO.getEAfm());
        Company company = companyRepository.getCompanyByName(employeeExtendeDTO.getCName());

        if (!employeeList.isEmpty()) {
            log.info("Autos o man uparxei hdh");
        } else {
            EmployeeDTO employeeDTO = employeeExtendeDTO.getEmployeeDTO();
            Employee employee = employeeMapper.toEntity(employeeDTO);
            employee.setEFirstName(employeeDTO.getEFirstName());

            Employee newEmployee = employeeRepository.save(employee);

            CompanyEmployee companyEmployee = new CompanyEmployee();
            companyEmployee.setCompany(company);
            companyEmployee.setEmployee(newEmployee);

            companyEmployeeRepository.save(companyEmployee);
        }
        return employeeExtendeDTO;
    }
}
