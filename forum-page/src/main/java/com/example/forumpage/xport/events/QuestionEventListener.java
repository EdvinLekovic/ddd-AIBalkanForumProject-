//package com.example.forumpage.xport.events;
//
//import com.example.forumpage.domain.models.ids.QuestionId;
//import com.example.forumpage.domain.valueobjects.UserId;
//import com.example.forumpage.service.QuestionService;
//import com.example.forumpage.service.form.QuestionForm;
//import com.example.sharedkernel.domain.config.TopicHolder;
//import com.example.sharedkernel.domain.events.forum.QuestionCreated;
//import com.example.sharedkernel.domain.events.forum.QuestionRemoved;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import lombok.AllArgsConstructor;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class QuestionEventListener {
//
//    private final QuestionService questionService;
//
//    @KafkaListener(topics = TopicHolder.TOPIC_QUESTION_CREATED,groupId = "AIForum")
//    public void consumeQuestionCreatedEvent(String jsonMessage){
//        try {
//            QuestionCreated event = QuestionCreated.fromJson(jsonMessage,QuestionCreated.class);
//            QuestionForm questionForm =
//                    new QuestionForm(event.getTitle(),
//                    event.getDescription(),
//                    UserId.of(event.getUserId()));
//            questionService.createQuestion(questionForm);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @KafkaListener(topics = TopicHolder.TOPIC_QUESTION_REMOVED,groupId = "AIForum")
//    public void consumeQuestionRemovedEvent(String jsonMessage){
//        try {
//            QuestionRemoved event = QuestionRemoved.fromJson(jsonMessage,QuestionRemoved.class);
//            questionService.deleteQuestion(QuestionId.of(event.getQuestionId()));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
