package com.example.forumpage.service.form;

import com.example.forumpage.domain.models.ids.QuestionId;
import com.example.forumpage.domain.valueobjects.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerForm {

    @NotNull
    private String description;

    @NotNull
    private QuestionId questionId;

    @NotNull
    private UserId userId;

}
