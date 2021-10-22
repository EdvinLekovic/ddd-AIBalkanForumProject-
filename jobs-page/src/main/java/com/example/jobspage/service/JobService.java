package com.example.jobspage.service;

import com.example.jobspage.domain.model.Job;
import com.example.jobspage.domain.model.ids.JobId;
import com.example.jobspage.service.forms.JobForm;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findAll();
    Optional<Job> findJobById(JobId jobId);
    Optional<Job> addJob(JobForm jobForm);
    void deleteJob(JobId jobId);
}
