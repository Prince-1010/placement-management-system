package com.example.placement.service;

import com.example.placement.entity.JobEntity;
import com.example.placement.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public JobEntity saveJob(JobEntity job){
        return jobRepository.save(job);
    }
    public List<JobEntity> getAllJobs(){
        return jobRepository.findAll();
    }
}
