package com.example.jobspage.service;

import com.example.jobspage.domain.model.Company;
import com.example.jobspage.domain.model.Job;
import com.example.jobspage.domain.model.enumeration.JobType;
import com.example.jobspage.domain.model.ids.CompanyId;
import com.example.jobspage.domain.model.ids.JobId;
import com.example.jobspage.domain.valueobjects.Category;
import com.example.jobspage.service.forms.CompanyForm;
import com.example.jobspage.service.forms.JobForm;
import com.example.sharedkernel.domain.image.Image;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> findAllCompanies();
    Company findCompanyByName(String name);
    List<Job> findAllJobsByCompanyName(String companyName);
    Company addCompany(CompanyForm companyForm);
    void deleteCompany(CompanyId companyId);
    void addJob(CompanyId companyId, JobForm jobForm);
    void deleteJob(CompanyId companyId, JobId jobId);
    List<Job> findAllJobsFromAllCompanies();
    Optional<Job> findJobByCompanyId(CompanyId companyId,JobId jobId);
}
