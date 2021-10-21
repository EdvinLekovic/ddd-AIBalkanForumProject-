package com.example.jobspage.xport;

import com.example.jobspage.domain.model.Company;
import com.example.jobspage.domain.model.Job;
import com.example.jobspage.domain.model.ids.CompanyId;
import com.example.jobspage.domain.model.ids.JobId;
import com.example.jobspage.service.CompanyService;
import com.example.jobspage.service.forms.JobForm;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("api/companies")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CompanyResource {

    private final CompanyService companyService;

    @GetMapping
    public List<Company> findAllCompanies(){
        return companyService.findAllCompanies();
    }

    @GetMapping("/jobs")
    public List<Job> findAllJobs(){
        return companyService.findAllJobsFromAllCompanies();
    }

    @PostMapping("/addJob")
    public void addJob(CompanyId companyId, JobForm jobForm){
        companyService.addJob(companyId,jobForm);
    }

    @DeleteMapping("/deleteJob/{companyId}/{jobId}")
    public void deleteJob(@PathVariable CompanyId companyId,@PathVariable JobId jobId){
        companyService.deleteJob(companyId,jobId);
    }

}
