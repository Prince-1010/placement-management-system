package com.example.placement.controller;

import com.example.placement.entity.ApplicationEntity;
import com.example.placement.entity.ApplicationStatus;
import com.example.placement.entity.CompanyEntity;
import com.example.placement.entity.StudentEntity;
import com.example.placement.repository.ApplicationRepository;
import com.example.placement.service.ApplicationService;
import com.example.placement.service.CompanyService;
import com.example.placement.service.StudentService;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService service;
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationRepository applicationRepo;

    @PostMapping
    public CompanyEntity addCompany(@RequestBody CompanyEntity company){
        return service.saveCompany(company);
    }

    @GetMapping
    public List<CompanyEntity> getCompanies(){
        return service.getAllCompany();
    }
    @GetMapping("/applications/{jobId}")
    public List<ApplicationEntity>getApplications(@PathVariable Long jobId){
        return applicationService.getApplicatioansByJob(jobId);
    }
    @PutMapping("/applications/{id}/status")
    public ResponseEntity<?>updateStatus(@PathVariable Long id, @RequestParam String status, Authentication authentication){
        String email=authentication.getName();
        return applicationService.updateStatus(id,status,email);
    }
}
