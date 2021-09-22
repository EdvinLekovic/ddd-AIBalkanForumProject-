package com.example.forumpage.service;

import com.example.forumpage.domain.models.Answer;
import com.example.forumpage.domain.models.Question;
import com.example.forumpage.domain.models.ids.AnswerId;
import com.example.forumpage.domain.models.ids.QuestionId;
import com.example.forumpage.service.form.AnswerForm;
import com.example.forumpage.service.form.QuestionForm;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> findAll();
    Optional<Question> findById(QuestionId questionId);
    QuestionId createQuestion(QuestionForm questionForm);
    void deleteQuestion(QuestionId questionId);
    void addAnswer(QuestionId questionId, AnswerForm answerForm);
    void deleteAnswer(QuestionId questionId, AnswerId answerId);
    List<Answer> findAllAnswersByQuestion(QuestionId questionId);
}
