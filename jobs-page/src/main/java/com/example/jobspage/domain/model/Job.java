package com.example.jobspage.domain.model;

import com.example.jobspage.domain.model.enumeration.JobType;
import com.example.jobspage.domain.model.ids.JobId;
import com.example.jobspage.domain.valueobjects.Category;
import com.example.jobspage.domain.valueobjects.Company;
import com.example.jobspage.domain.valueobjects.Location;
import com.example.jobspage.domain.valueobjects.UserId;
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

    private Category category;

    private Company company;

    private UserId userId;

    protected Job() {
        super(JobId.randomId(JobId.class));
    }

    public Job(JobType jobType,
               String description,
               String knowLedgeSkillsAndAbilities,
               String experience,
               String salary,
               LocalDateTime dateCreated,
               LocalDateTime deadlineApply,
               Location location,
               Category category,
               Company company,
                UserId userId) {
        super(JobId.randomId(JobId.class));
        this.jobType = jobType;
        this.description = description;
        this.knowLedgeSkillsAndAbilities = knowLedgeSkillsAndAbilities;
        this.experience = experience;
        this.salary = salary;
        this.dateCreated = dateCreated;
        this.deadlineApply = deadlineApply;
        this.location = location;
        this.category = category;
        this.company = company;
        this.userId = userId;
    }
}
