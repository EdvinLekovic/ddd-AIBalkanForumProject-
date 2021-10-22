package com.example.sharedkernel.domain.events.forum;

import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class AnswerRemoved extends DomainEvent {

    private String answerId;
    private String questionId;

    public AnswerRemoved() {
        super(TopicHolder.TOPIC_ANSWER_REMOVED);
    }

    public AnswerRemoved(String answerId, String questionId) {
        super(TopicHolder.TOPIC_ANSWER_REMOVED);
        this.answerId = answerId;
        this.questionId = questionId;
    }
}

