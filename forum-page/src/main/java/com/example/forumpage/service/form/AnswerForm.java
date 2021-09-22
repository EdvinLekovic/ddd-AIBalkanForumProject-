package com.example.forumpage.service.form;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class AnswerForm {

    @NotNull
    private String description;

}
