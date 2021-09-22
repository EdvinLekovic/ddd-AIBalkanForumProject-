package com.example.jobspage.service.forms;

import com.example.jobspage.domain.model.Job;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class CompanyForm {

    @NotNull
    private String name;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    @NotEmpty
    List<Job> jobList = new ArrayList<>();

}
