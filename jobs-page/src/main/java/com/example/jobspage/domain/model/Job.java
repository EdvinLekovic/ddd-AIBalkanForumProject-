package com.example.jobspage.domain.model;

import com.example.jobspage.domain.model.enumeration.JobType;
import com.example.jobspage.domain.model.ids.JobId;
import com.example.jobspage.domain.valueobjects.Category;
import com.example.jobspage.domain.valueobjects.Location;
import com.example.sharedkernel.domain.base.AbstractEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class Job extends AbstractEntity<JobId> {

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private String description;

    private String knowLedgeSkillsAndAbilities;

    private String experience;

    private String salary;

    private LocalDateTime dateCreated;

    private LocalDateTime deadlineApply;


    private Location location;

    @OneToMany
    private List<Company> companies;

    Category category;

    protected Job() {
        super(JobId.randomId(JobId.class));
    }

    public Job(JobType jobType,
               String description,
               String knowLedgeSkillsAndAbilities,
               String experience,
               String salary,
               List<Company> companies,
               Location location,
               LocalDateTime dateCreated,
               LocalDateTime deadlineApply,
               Category category) {
        super(JobId.randomId(JobId.class));
        this.jobType = jobType;
        this.description = description;
        this.knowLedgeSkillsAndAbilities = knowLedgeSkillsAndAbilities;
        this.experience = experience;
        this.salary = salary;
        this.location = location;
        this.companies = companies;
        this.dateCreated = dateCreated;
        this.deadlineApply = deadlineApply;
        this.category = category;
    }
}
