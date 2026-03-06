package com.example.placement.controller;

import com.example.placement.entity.JobEntity;
import com.example.placement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/jobs")
    public JobEntity addJob(@RequestBody JobEntity job){
        return jobService.saveJob(job);
    }

    @GetMapping("/jobs")
    public List<JobEntity> getJobs(){
        return jobService.getAllJobs();
    }
}
