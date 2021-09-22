package com.example.forumpage.domain.models;

import com.example.forumpage.domain.models.ids.AnswerId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import lombok.Getter;


import javax.persistence.Entity;


@Entity
@Getter
public class Answer extends AbstractEntity<AnswerId> {

    private String description;

    protected Answer(){
        super(AnswerId.randomId(AnswerId.class));
    }

    public Answer(String description) {
        super(AnswerId.randomId(AnswerId.class));
        this.description = description;
    }


}
