package com.example.sharedkernel.domain.events.forum;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

import java.time.Instant;

@Getter
public class QuestionCreated extends DomainEvent {

    private String questionId;
    private String title;
    private String description;
    private String userId;

    public QuestionCreated() {
        super(TopicHolder.TOPIC_QUESTION_CREATED);
    }

    public QuestionCreated(String questionId, String title, String description, String userId) {
        super(TopicHolder.TOPIC_QUESTION_REMOVED);
        this.questionId = questionId;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

}
