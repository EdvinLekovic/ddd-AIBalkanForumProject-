package com.example.forumpage.domain.exceptions;

import com.example.forumpage.domain.models.ids.QuestionId;

public class QuestionNotFoundException extends RuntimeException {

    public QuestionNotFoundException(QuestionId id) {
        super(String.format("Question with id %s does not exist", id.getId()));
    }
}
