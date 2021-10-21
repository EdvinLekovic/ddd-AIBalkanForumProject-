package com.example.forumpage.domain.models.ids;

import com.example.forumpage.domain.models.Question;
import com.example.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;


public class QuestionId extends DomainObjectId {

    private QuestionId(){
        super(QuestionId.randomId(QuestionId.class).getId());
    }

    public QuestionId(@NonNull String uuid){
        super(uuid);
    }

    public static QuestionId of(String uuid){
        return new QuestionId(uuid);
    }
}
