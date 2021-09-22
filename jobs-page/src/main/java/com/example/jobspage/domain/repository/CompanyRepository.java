package com.example.jobspage.domain.repository;

import com.example.jobspage.domain.model.Company;
import com.example.jobspage.domain.model.Job;
import com.example.jobspage.domain.model.ids.CompanyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, CompanyId> {
    Company findCompanyByName(String name);

}
