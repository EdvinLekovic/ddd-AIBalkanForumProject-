package com.example.jobspage.service.impl;

import com.example.jobspage.domain.model.Job;
import com.example.jobspage.domain.model.ids.JobId;
import com.example.jobspage.domain.repository.JobRepository;
import com.example.jobspage.service.JobService;
import com.example.jobspage.service.forms.JobForm;
import com.example.sharedkernel.domain.events.jobs.JobCreated;
import com.example.sharedkernel.domain.events.jobs.JobRemoved;
import com.example.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    private final DomainEventPublisher domainEventPublisher;

    public JobServiceImpl(JobRepository jobRepository, DomainEventPublisher domainEventPublisher) {
        this.jobRepository = jobRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findJobById(JobId jobId) {
        return jobRepository.findById(jobId);
    }

    @Override
    public Optional<Job> addJob(JobForm jobForm) {
        LocalDateTime deadlineApply = LocalDateTime
                .ofInstant(jobForm.getDeadlineApply().toInstant(), ZoneId.systemDefault());
        Job job = new Job(jobForm.getJobType(),
                jobForm.getDescription(),
                jobForm.getKnowledgeSkillsAndAbilities(),
                jobForm.getExperience(),
                jobForm.getSalary(),
                LocalDateTime.now(),
                deadlineApply,
                jobForm.getLocation(),
                jobForm.getCategory(),
                jobForm.getCompany(),
                jobForm.getUserId());
        jobRepository.save(job);
        domainEventPublisher.publish(new JobCreated(jobForm.getJobType().toString(),
                jobForm.getDescription(),
                jobForm.getKnowledgeSkillsAndAbilities(),
                jobForm.getExperience(),
                jobForm.getSalary(),
                jobForm.getDeadlineApply(),
                jobForm.getLocation().getCountryAndCity(),
                jobForm.getCategory().getCategoryName(),
                jobForm.getCompany().getCompanyName(),
                jobForm.getUserId().getId()));
        return Optional.of(job);
    }

    @Override
    public void deleteJob(JobId jobId) {
        jobRepository.deleteById(jobId);
        domainEventPublisher.publish(new JobRemoved(jobId.getId()));
    }
}
