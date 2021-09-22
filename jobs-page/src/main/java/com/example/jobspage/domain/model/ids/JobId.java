package com.example.jobspage.domain.model.ids;

import com.example.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class JobId extends DomainObjectId {

    private JobId(){
        super(JobId.randomId(JobId.class).getId());
    }

    public JobId(@NonNull String uuid){
        super(uuid);
    }
}
