package com.example.forumpage.xport.rest;

import com.example.forumpage.domain.models.Answer;
import com.example.forumpage.domain.models.Question;
import com.example.forumpage.domain.models.ids.AnswerId;
import com.example.forumpage.domain.models.ids.QuestionId;
import com.example.forumpage.service.QuestionService;
import com.example.forumpage.service.form.AnswerForm;
import com.example.forumpage.service.form.QuestionForm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class QuestionResource {

    private final QuestionService questionService;

    @GetMapping
    public List<Question> findAllQuestions() {
        return questionService.findAll();
    }

    @GetMapping("/answers")
    public List<Answer> findAllAnswersByQuestion(QuestionId questionId) {
        return questionService.findAllAnswersByQuestion(questionId);
    }

    @GetMapping("/{id}")
    public Optional<Question> findQuestionById(@PathVariable QuestionId id) {
        return questionService.findById(id);
    }

    @PostMapping("/createQuestion")
    public void createQuestion(@RequestBody QuestionForm questionForm) {
        questionService.createQuestion(questionForm);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public void deleteQuestion(@PathVariable String id) {
        questionService.deleteQuestion(new QuestionId(id));
    }

    @PostMapping("/createAnswer")
    public void createAnswer(QuestionId questionId, AnswerForm answerForm) {
        questionService.addAnswer(questionId, answerForm);
    }

    @DeleteMapping("/deleteAnswer/{questionId}/{answerId}")
    public void deleteAnswer(@PathVariable QuestionId questionId,@PathVariable AnswerId answerId) {
        questionService.deleteAnswer(questionId, answerId);
    }


}
