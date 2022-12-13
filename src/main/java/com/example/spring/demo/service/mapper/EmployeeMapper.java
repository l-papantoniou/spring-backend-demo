package com.example.spring.demo.service.mapper;

import com.example.spring.demo.model.Company;
import com.example.spring.demo.model.Employee;
import com.example.spring.demo.service.dto.CompanyDTO;
import com.example.spring.demo.service.dto.EmployeeDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class EmployeeMapper {
    @Autowired
    private ModelMapper modelMapper;


    //entity to DTO
    public EmployeeDTO toDto(Employee employee) {

        return modelMapper.map(employee, EmployeeDTO.class);
    }

    //DTO to entity
    public Employee toEntity(EmployeeDTO employeeDTO) {

        return modelMapper.map(employeeDTO, Employee.class);
    }
}
