package com.example.spring.demo.repository;

import com.example.spring.demo.model.Employee;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT employee FROM Employee employee WHERE employee.eAfm=:eAfm")
    List<Employee> getEmployeeByAfm(@Param("eAfm") String eAfm);

 }
