package com.example.forumpage.service.impl;

import com.example.forumpage.domain.exceptions.QuestionNotFoundException;
import com.example.forumpage.domain.models.Answer;
import com.example.forumpage.domain.models.Question;
import com.example.forumpage.domain.models.ids.AnswerId;
import com.example.forumpage.domain.models.ids.QuestionId;
import com.example.forumpage.domain.repository.QuestionRepository;
import com.example.forumpage.domain.valueobjects.UserId;
import com.example.forumpage.service.QuestionService;
import com.example.forumpage.service.form.AnswerForm;
import com.example.forumpage.service.form.QuestionForm;
import com.example.sharedkernel.domain.events.DomainEvent;
import com.example.sharedkernel.domain.events.forum.AnswerCreated;
import com.example.sharedkernel.domain.events.forum.AnswerRemoved;
import com.example.sharedkernel.domain.events.forum.QuestionCreated;
import com.example.sharedkernel.domain.events.forum.QuestionRemoved;
import com.example.sharedkernel.infra.DomainEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final DomainEventPublisher domainEventPublisher;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(QuestionId questionId) {
        return questionRepository.findById(questionId);
    }

    @Override
    public QuestionId createQuestion(QuestionForm questionForm) {
        Question question =
                new Question(questionForm.getTitle(),
                        questionForm.getDescription(),
                        questionForm.getAnswerList(),
                        LocalDateTime.now(),
                        new UserId(questionForm.getUserId()));
        questionRepository.saveAndFlush(question);
        domainEventPublisher.publish(new QuestionCreated(question.getId().getId(),
                question.getTitle(),
                question.getDescription(),
                question.getUserId().getId()));
        return question.getId();
    }

    @Override
    public void deleteQuestion(QuestionId questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new QuestionNotFoundException(questionId));
        questionRepository.deleteById(questionId);
        domainEventPublisher
                .publish(new QuestionRemoved(questionId.getId(),
                question.getTitle(),
                question.getDescription(),
                question.getUserId().getId()));
    }

    @Override
    public void addAnswer(AnswerForm answerForm) {
        Question question = questionRepository.findById(answerForm.getQuestionId())
                        .orElseThrow(() -> new QuestionNotFoundException(answerForm.getQuestionId()));
        question.addAnswer(answerForm.getDescription(),answerForm.getUserId(),LocalDateTime.now());
        questionRepository.saveAndFlush(question);
        domainEventPublisher.publish(new AnswerCreated(answerForm.getDescription(),
                answerForm.getQuestionId().getId(),
                answerForm.getUserId().getId()));
    }

    @Override
    public void deleteAnswer(QuestionId questionId, AnswerId answerId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException(questionId));
        question.delete(answerId);
        questionRepository.save(question);
        domainEventPublisher.publish(new AnswerRemoved(answerId.getId(),questionId.getId()));
    }

    @Override
    public List<Answer> findAllAnswersByQuestion(QuestionId questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException(questionId));
        return question.getAnswerList();
    }


}
