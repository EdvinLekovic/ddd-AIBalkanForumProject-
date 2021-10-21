package com.example.sharedkernel.domain.events.forum;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class AnswerRemoved extends DomainEvent {

    private String description;
    private String questionId;

    public AnswerRemoved(String topic) {
        super(TopicHolder.TOPIC_ANSWER_REMOVED);
    }

    public AnswerRemoved(String topic, String description, String questionId) {
        super(TopicHolder.TOPIC_ANSWER_REMOVED);
        this.description = description;
        this.questionId = questionId;
    }
}

