package com.example.forumpage.domain.models;

import com.example.forumpage.domain.models.ids.AnswerId;
import com.example.forumpage.domain.models.ids.QuestionId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
public class Question extends AbstractEntity<QuestionId> {

    private String title;

    private String description;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    List<Answer> answerList = new ArrayList<>();

    private LocalDateTime dateCreated;

    protected Question(){
        super(QuestionId.randomId(QuestionId.class));
    }

    public Question(String title,
                    String description,
                    List<Answer> answerList,
                    LocalDateTime dateCreated) {
        super(QuestionId.randomId(QuestionId.class));
        this.title = title;
        this.description = description;
        this.answerList = answerList;
        this.dateCreated = dateCreated;
    }

    public void addAnswer(String answerDescription){
        Objects.requireNonNull(answerDescription,"answerUserId must not be null");
        Answer answer = new Answer(answerDescription);
        answerList.add(answer);
    }

    public void delete(AnswerId answerId){
        Objects.requireNonNull(answerId,"Answer must not be null");
        answerList.removeIf(a -> a.getId().equals(answerId));
    }
}
