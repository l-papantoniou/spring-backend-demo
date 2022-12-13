package com.example.spring.demo.repository;

import com.example.spring.demo.model.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyEmployeeRepository extends JpaRepository<CompanyEmployee, Long> {
}
