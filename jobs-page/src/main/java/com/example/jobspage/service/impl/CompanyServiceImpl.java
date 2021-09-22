package com.example.jobspage.service.impl;

import com.example.jobspage.domain.exception.CompanyNotFoundException;
import com.example.jobspage.domain.model.Company;
import com.example.jobspage.domain.model.Job;
import com.example.jobspage.domain.model.ids.CompanyId;
import com.example.jobspage.domain.model.ids.JobId;
import com.example.jobspage.domain.repository.CompanyRepository;
import com.example.jobspage.service.CompanyService;
import com.example.jobspage.service.forms.CompanyForm;
import com.example.jobspage.service.forms.JobForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;


    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company findCompanyByName(String name) {
         return companyRepository.findCompanyByName(name);
    }

    @Override
    public List<Job> findAllJobsByCompanyName(String companyName) {
        return companyRepository.findCompanyByName(companyName).getJobList();
    }

    @Override
    public Company addCompany(CompanyForm companyForm) {
        Company company = new Company(companyForm.getName(),companyForm.getCity(),companyForm.getCountry(),companyForm.getJobList());
        companyRepository.save(company);
        return  company;
    }

    @Override
    public void deleteCompany(CompanyId companyId) {
        companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException(companyId));
        companyRepository.findById(companyId);
    }

    @Override
    public void addJob(CompanyId companyId, JobForm jobForm) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException(companyId));
        companyRepository.findById(companyId);
        LocalDateTime dateCreated = LocalDateTime.ofInstant(jobForm.getDeadlineApply().toInstant(), ZoneId.systemDefault());
        company.addJob(jobForm.getJobType(),
                jobForm.getDescription(),
                jobForm.getKnowLedgeSkillsAndAbilities(),
                jobForm.getExperience(),
                jobForm.getSalary(),
                jobForm.getLocation(),
                LocalDateTime.now(),
                dateCreated,
                jobForm.getCategory());
        companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteJob(CompanyId companyId, JobId jobId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException(companyId));
        companyRepository.findById(companyId);
        company.deleteJob(jobId);
    }

    @Override
    public List<Job> findAllJobsFromAllCompanies() {
        return companyRepository.findAll().stream().flatMap(c -> c.getJobList().stream()).collect(Collectors.toList());
    }

    @Override
    public Optional<Job> findJobByCompanyId(CompanyId companyId,JobId jobId) {

        Company company = companyRepository.findById(companyId)
                 .orElseThrow(() -> new CompanyNotFoundException(companyId));

         return company.getJobList().stream().filter(job -> job.getId().equals(jobId)).findFirst();
    }

}