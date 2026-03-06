package com.example.placement.service;

import com.example.placement.entity.ApplicationEntity;
import com.example.placement.entity.ApplicationStatus;
import com.example.placement.entity.JobEntity;
import com.example.placement.entity.StudentEntity;
import com.example.placement.repository.ApplicationRepository;
import com.example.placement.repository.JobRepository;
import com.example.placement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JobRepository jobRepository;

    public ApplicationEntity applyJob(Long studentId, Long jobId){

        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        JobEntity job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        ApplicationEntity application = new ApplicationEntity();
        application.setStudent(student);
        application.setJob(job);
        application.setStatus(ApplicationStatus.APPLIED);

        return applicationRepository.save(application);
    }


    public List<ApplicationEntity> getApplicatioansByJob(Long jobId){
        return applicationRepository.findByJobId(jobId);
    }
    public ResponseEntity<?> updateStatus(Long id, String status, String currentCompanyEmail) {

        ApplicationEntity app = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));


        if (!app.getJob().getCompany().getEmail().equals(currentCompanyEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("You cannot update this application");
        }

        app.setStatus(ApplicationStatus.valueOf(status));
        applicationRepository.save(app);

        return ResponseEntity.ok("Application status updated");
    }
}
