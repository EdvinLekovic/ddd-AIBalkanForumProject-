package com.example.forumpage.service.form;

import com.example.forumpage.domain.models.Answer;
import com.example.forumpage.domain.valueobjects.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionForm {

    @NotNull
    private String title;

    @NotNull
    private String description;

    List<Answer> answerList = new ArrayList<>();

    @NotNull
    private String userId;

}
