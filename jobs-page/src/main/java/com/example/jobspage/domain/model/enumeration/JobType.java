package com.example.jobspage.domain.model.enumeration;

import com.example.jobspage.domain.model.Job;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JobType {
    FULL_TIME("FULL_TIME"),
    PART_TIME("PART_TIME"),
     REMOTE("REMOTE"),
    FREELANCE("FREELANCE");

    @JsonValue
    private String jobType;

    JobType(String jobType){
        this.jobType = jobType;
    }

    @JsonCreator
    public static JobType getJobType(String value) {

        for (JobType jType : JobType.values()) {

            if (jType.jobType.equals(value)) {

                return jType;
            }
        }

        return null;
    }
}
