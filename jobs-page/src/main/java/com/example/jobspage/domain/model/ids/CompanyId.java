package com.example.jobspage.domain.model.ids;

import com.example.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class CompanyId extends DomainObjectId {

    private CompanyId(){
        super(CompanyId.randomId(CompanyId.class).getId());
    }

    public CompanyId(@NonNull String uuid){
        super(uuid);
    }
}
