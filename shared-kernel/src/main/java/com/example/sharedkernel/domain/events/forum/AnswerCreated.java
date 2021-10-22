package com.example.sharedkernel.domain.events.forum;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class AnswerCreated extends DomainEvent {

    private String description;
    private String questionId;
    private String userId;

    public AnswerCreated() {
        super(TopicHolder.TOPIC_ANSWER_CREATED);
    }

    public AnswerCreated(String description, String questionId,String userId) {
        super(TopicHolder.TOPIC_ANSWER_CREATED);
        this.description = description;
        this.questionId = questionId;
        this.userId = userId;
    }
}
