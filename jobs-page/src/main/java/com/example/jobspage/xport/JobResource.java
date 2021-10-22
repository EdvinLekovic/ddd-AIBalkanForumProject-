package com.example.jobspage.xport;

import com.example.jobspage.domain.model.Job;
import com.example.jobspage.domain.model.ids.JobId;
import com.example.jobspage.service.JobService;
import com.example.jobspage.service.forms.JobForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class JobResource {

    private final JobService jobService;


    @GetMapping
    public List<Job> listAllJobs() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Job> getJobById(@PathVariable String id) {
        return jobService.findJobById(new JobId(id));
    }

    @PostMapping("/addJob")
    public Optional<Job> addJob(@RequestBody JobForm jobForm) {
        return jobService.addJob(jobForm);
    }

    @DeleteMapping("/deleteJob/{id}")
    public void deleteJob(@PathVariable String id) {
        jobService.deleteJob(new JobId(id));
    }
}
