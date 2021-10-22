package com.example.jobspage.service.forms;

import com.example.jobspage.domain.model.enumeration.JobType;
import com.example.jobspage.domain.valueobjects.Category;
import com.example.jobspage.domain.valueobjects.Company;
import com.example.jobspage.domain.valueobjects.Location;
import com.example.jobspage.domain.valueobjects.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobForm {

    @NotNull
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @NotNull
    private String description;

    @NotNull
    private String knowledgeSkillsAndAbilities;

    @NotNull
    private String experience;

    @NotNull
    private String salary;

    @NotNull
    private Date deadlineApply;

    @NotNull
    private Location location;

    @NotNull
    private Category category;

    @NotNull
    private Company company;

    @NotNull
    private UserId userId;

}
