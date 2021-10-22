package com.example.sharedkernel.domain.events.jobs;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

import java.util.Date;

@Getter
public class JobRemoved extends DomainEvent {

    private String jobId;

    public JobRemoved() {
        super(TopicHolder.TOPIC_JOB_REMOVED);
    }

    public JobRemoved(String jobId) {
        super(TopicHolder.TOPIC_JOB_REMOVED);
        this.jobId = jobId;
    }
}
