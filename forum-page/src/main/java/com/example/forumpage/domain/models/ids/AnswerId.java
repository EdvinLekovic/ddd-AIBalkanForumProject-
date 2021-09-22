package com.example.forumpage.domain.models.ids;

import com.example.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class AnswerId extends DomainObjectId {

    private AnswerId(){
        super(AnswerId.randomId(AnswerId.class).getId());
    }

    public AnswerId(@NonNull String uuid){
        super(uuid);
    }
}
