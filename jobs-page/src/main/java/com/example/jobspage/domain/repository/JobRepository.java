package com.example.jobspage.domain.repository;

import com.example.jobspage.domain.model.Job;
import com.example.jobspage.domain.model.ids.JobId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, JobId> {
}
