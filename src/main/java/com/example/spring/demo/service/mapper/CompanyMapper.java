package com.example.spring.demo.service.mapper;

import com.example.spring.demo.model.Company;
import com.example.spring.demo.service.dto.CompanyDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class CompanyMapper {
    @Autowired
    private ModelMapper modelMapper;

    //entity to DTO
    public CompanyDTO toDto(Company company) {
        return modelMapper.map(company, CompanyDTO.class);
    }

    //DTO to entity
    public Company toEntity(CompanyDTO companyDTO) {
        return modelMapper.map(companyDTO, Company.class);
    }
}
