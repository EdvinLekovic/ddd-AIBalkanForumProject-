package com.example.jobspage.domain.valueobjects;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Category {

    private final String categoryName;

    private final String categoryDescription;

    protected Category(){
        this.categoryName = null;
        this.categoryDescription = null;
    }

}
