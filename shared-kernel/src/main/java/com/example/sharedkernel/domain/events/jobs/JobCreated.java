package com.example.sharedkernel.domain.events.jobs;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
public class JobCreated extends DomainEvent {

    private String jobType;

    private String description;

    private String knowledgeSkillsAndAbilities;

    private String experience;

    private String salary;

    private Date deadlineApply;

    private String location;

    private String category;

    private String company;

    private String userId;

    public JobCreated(){
        super(TopicHolder.TOPIC_JOB_CREATED);
    }

    public JobCreated(String jobType,
                      String description,
                      String knowledgeSkillsAndAbilities,
                      String experience,
                      String salary,
                      Date deadlineApply,
                      String location,
                      String category,
                      String company,
                      String userId) {
        super(TopicHolder.TOPIC_JOB_CREATED);
        this.jobType = jobType;
        this.description = description;
        this.knowledgeSkillsAndAbilities = knowledgeSkillsAndAbilities;
        this.experience = experience;
        this.salary = salary;
        this.deadlineApply = deadlineApply;
        this.location = location;
        this.category = category;
        this.company = company;
        this.userId = userId;
    }
}
