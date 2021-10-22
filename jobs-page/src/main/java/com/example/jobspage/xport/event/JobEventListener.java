package com.example.jobspage.xport.event;

import com.example.jobspage.domain.model.enumeration.JobType;
import com.example.jobspage.domain.model.ids.JobId;
import com.example.jobspage.domain.valueobjects.Category;
import com.example.jobspage.domain.valueobjects.Company;
import com.example.jobspage.domain.valueobjects.Location;
import com.example.jobspage.domain.valueobjects.UserId;
import com.example.jobspage.service.JobService;
import com.example.jobspage.service.forms.JobForm;
import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.forum.QuestionCreated;
import com.example.sharedkernel.domain.events.forum.QuestionRemoved;
import com.example.sharedkernel.domain.events.jobs.JobCreated;
import com.example.sharedkernel.domain.events.jobs.JobRemoved;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Service
@AllArgsConstructor
public class JobEventListener {

    private final JobService jobService;

    @KafkaListener(topics = TopicHolder.TOPIC_QUESTION_CREATED,groupId = "jobs")
    public void consumeQuestionCreatedEvent(String jsonMessage){
        try {
            JobCreated event = JobCreated.fromJson(jsonMessage,JobCreated.class);
            JobForm jobForm =
                    new JobForm(JobType.valueOf(event.getJobType()),
                            event.getDescription(),
                            event.getKnowledgeSkillsAndAbilities(),
                            event.getExperience(),
                            event.getSalary(),
                            event.getDeadlineApply(),
                            new Location(event.getLocation()),
                            new Category(event.getCategory()),
                            new Company(event.getCompany()),
                            new UserId(event.getUserId()));
            jobService.addJob(jobForm);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @KafkaListener(topics = TopicHolder.TOPIC_QUESTION_REMOVED,groupId = "jobs")
    public void consumeQuestionRemovedEvent(String jsonMessage){
        try {
            JobRemoved event = JobRemoved.fromJson(jsonMessage,JobRemoved.class);
            jobService.deleteJob(new JobId(event.getJobId()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
