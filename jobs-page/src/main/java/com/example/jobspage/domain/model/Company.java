package com.example.jobspage.domain.model;

import com.example.jobspage.domain.model.enumeration.JobType;
import com.example.jobspage.domain.model.ids.CompanyId;
import com.example.jobspage.domain.model.ids.JobId;
import com.example.jobspage.domain.valueobjects.Category;
import com.example.sharedkernel.domain.base.AbstractEntity;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Company extends AbstractEntity<CompanyId> {

    private String name;

    private String city;

    private String country;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Job> jobList = new ArrayList<>();

    protected Company(){
        super(CompanyId.randomId(CompanyId.class));
    }

    public Company(String name,String city, String country,List<Job> jobList) {
        super(CompanyId.randomId(CompanyId.class));
        this.name = name;
        this.city = city;
        this.country = country;
    }

}
