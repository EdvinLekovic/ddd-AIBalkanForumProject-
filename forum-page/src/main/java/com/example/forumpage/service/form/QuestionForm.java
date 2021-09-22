package com.example.forumpage.service.form;

import com.example.forumpage.domain.models.Answer;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionForm {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @Valid
    @NotEmpty
    List<Answer> answerList = new ArrayList<>();
}
