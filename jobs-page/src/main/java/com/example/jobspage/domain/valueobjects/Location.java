package com.example.jobspage.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private String countryAndCity;

}
