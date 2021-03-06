package com.example.forumpage.domain.models;

import com.example.forumpage.domain.models.ids.AnswerId;
import com.example.forumpage.domain.models.ids.QuestionId;
import com.example.forumpage.domain.valueobjects.UserId;
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

    private UserId userId;

    protected Question(){
        super(QuestionId.randomId(QuestionId.class));
    }

    public Question(String title,
                    String description,
                    List<Answer> answerList,
                    LocalDateTime dateCreated,
                    UserId userId) {
        super(QuestionId.randomId(QuestionId.class));
        this.title = title;
        this.description = description;
        this.answerList = answerList;
        this.dateCreated = dateCreated;
        this.userId = userId;
    }

    public Answer addAnswer(String answerDescription,UserId userId,LocalDateTime dateCreated){
        Objects.requireNonNull(answerDescription,"answerUserId must not be null");
        Answer answer = new Answer(answerDescription,userId,dateCreated);
        answerList.add(answer);
        return answer;
    }

    public void delete(AnswerId answerId){
        Objects.requireNonNull(answerId,"Answer must not be null");
        answerList.removeIf(a -> a.getId().getId().equals(answerId.getId()));
    }
}
