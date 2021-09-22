package com.example.jobspage.service.forms;

import com.example.jobspage.domain.model.enumeration.JobType;
import com.example.jobspage.domain.valueobjects.Category;
import com.example.jobspage.domain.valueobjects.Location;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class JobForm {

    @NotNull
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @NotNull
    private String description;

    @NotNull
    private String knowLedgeSkillsAndAbilities;

    @NotNull
    private String experience;

    @NotNull
    private String salary;

    @NotNull
    private Date deadlineApply;

    @NotNull
    private Location location;

    @NotNull
    Category category;

}
