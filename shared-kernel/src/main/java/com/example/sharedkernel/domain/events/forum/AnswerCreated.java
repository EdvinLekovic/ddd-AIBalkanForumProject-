package com.example.sharedkernel.domain.events.forum;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class AnswerCreated extends DomainEvent {

    private String description;
    private String questionId;

    public AnswerCreated(String topic) {
        super(TopicHolder.TOPIC_ANSWER_CREATED);
    }

    public AnswerCreated(String topic, String description, String questionId) {
        super(TopicHolder.TOPIC_ANSWER_CREATED);
        this.description = description;
        this.questionId = questionId;
    }
}
