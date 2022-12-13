package com.example.spring.demo.repository;


import com.example.spring.demo.model.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "SELECT company.cName FROM Company company WHERE company.cAfm=:cAfm ")
    List<String> getNameByAfm(@Param("cAfm") String cAfm);



    @Query(value = "SELECT company FROM Company company WHERE company.cName=:cName")
    Company getCompanyByName(@Param("cName") String cName);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Company company SET company=:company WHERE company.id=:cId")
    void updateCompany(@Param("company") Company company, @Param("cId") Long cId);

}
