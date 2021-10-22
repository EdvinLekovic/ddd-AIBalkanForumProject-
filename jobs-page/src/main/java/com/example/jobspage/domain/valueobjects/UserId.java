package com.example.jobspage.domain.valueobjects;

import com.example.sharedkernel.domain.base.DomainObjectId;

public class UserId extends DomainObjectId {

    protected UserId(){
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(String uuid){
        super(uuid);
    }

    public static UserId of(String uuid){
        return new UserId(uuid);
    }
}
