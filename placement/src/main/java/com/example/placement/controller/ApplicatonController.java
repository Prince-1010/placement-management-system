package com.example.placement.controller;

import com.example.placement.entity.ApplicationEntity;
import com.example.placement.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class ApplicatonController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ApplicationEntity applyJob(@RequestParam Long studentId, @RequestParam Long jobId){
        return applicationService.applyJob(studentId, jobId);
    }
    @GetMapping("/applications/{jobId}")
    public List<ApplicationEntity>getApplications(@PathVariable Long jobId){
        return applicationService.getApplicatioansByJob(jobId);
    }

}
