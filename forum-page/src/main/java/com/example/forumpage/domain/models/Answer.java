package com.example.forumpage.domain.models;

import com.example.forumpage.domain.models.ids.AnswerId;
import com.example.forumpage.domain.valueobjects.UserId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import lombok.Getter;


import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity
@Getter
public class Answer extends AbstractEntity<AnswerId> {

    private String description;

    private UserId userId;

    private LocalDateTime dateCreated;

    protected Answer(){
        super(AnswerId.randomId(AnswerId.class));
    }

    public Answer(String description,UserId userId,LocalDateTime dateCreated) {
        super(AnswerId.randomId(AnswerId.class));
        this.description = description;
        this.userId = userId;
        this.dateCreated = dateCreated;
    }

}
