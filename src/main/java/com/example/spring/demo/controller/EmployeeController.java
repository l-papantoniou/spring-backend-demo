package com.example.spring.demo.controller;


import com.example.spring.demo.model.Employee;
import com.example.spring.demo.service.EmployeeService;
import com.example.spring.demo.service.dto.EmployeeExtendeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    //REST API
    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("/hireemployee")
    public EmployeeExtendeDTO hireEmployee(@RequestBody EmployeeExtendeDTO employeeExtendeDTO) {
        return employeeService.hireEmployee(employeeExtendeDTO);
    }

    @GetMapping("/employeeafm/{afm}")
    public List<Employee> getEmployeeByAfm(@PathVariable String afm) {
        return employeeService.getEmployeeByAfm(afm);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> findEmployee(@PathVariable Integer id) {
        return employeeService.findEmployee(id);
    }

    @DeleteMapping("{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        employeeService.deleteEmployee(employeeId);

        return "Deleted employee id - " + employeeId;
    }

    ;
}
