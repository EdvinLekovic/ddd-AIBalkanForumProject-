package com.example.jobspage.domain.valueobjects;
import lombok.Getter;
import javax.persistence.Embeddable;


@Embeddable
@Getter
public class Location {

    private String city;

    private String country;

    protected Location(){
        this.city = null;
        this.country = null;
    }

}
