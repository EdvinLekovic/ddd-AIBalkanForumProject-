package com.example.forumpage.xport.events;

import com.example.forumpage.domain.models.ids.AnswerId;
import com.example.forumpage.domain.models.ids.QuestionId;
import com.example.forumpage.domain.valueobjects.UserId;
import com.example.forumpage.service.QuestionService;
import com.example.forumpage.service.form.AnswerForm;
import com.example.forumpage.service.form.QuestionForm;
import com.example.sharedkernel.domain.config.TopicHolder;
import com.example.sharedkernel.domain.events.forum.AnswerCreated;
import com.example.sharedkernel.domain.events.forum.AnswerRemoved;
import com.example.sharedkernel.domain.events.forum.QuestionCreated;
import com.example.sharedkernel.domain.events.forum.QuestionRemoved;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class AnswerEventListener {

    private final QuestionService questionService;

    @KafkaListener(topics = TopicHolder.TOPIC_QUESTION_CREATED, groupId = "AIForum")
    public void consumeAnswerCreatedEvent(String jsonMessage) {
        try {
            AnswerCreated event = AnswerCreated.fromJson(jsonMessage, AnswerCreated.class);
            AnswerForm answerForm = new AnswerForm(event.getDescription(),
                    new QuestionId(event.getQuestionId()),
                    new UserId(event.getUserId()));
            questionService.addAnswer(answerForm);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @KafkaListener(topics = TopicHolder.TOPIC_QUESTION_REMOVED, groupId = "AIForum")
    public void consumeQuestionRemovedEvent(String jsonMessage) {
        try {
            AnswerRemoved event = AnswerRemoved.fromJson(jsonMessage, AnswerRemoved.class);
            questionService.deleteAnswer(new QuestionId(event.getQuestionId()), new AnswerId(event.getAnswerId()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
