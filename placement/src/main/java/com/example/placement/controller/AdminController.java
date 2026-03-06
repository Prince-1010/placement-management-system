package com.example.placement.controller;

import com.example.placement.DTO.RegisterRequest;
import com.example.placement.entity.*;
import com.example.placement.repository.CompanyRepository;
import com.example.placement.repository.StudentRepository;
import com.example.placement.repository.UserRepository;
import com.example.placement.service.ApplicationService;
import com.example.placement.service.CompanyService;
import com.example.placement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private CompanyRepository companyRepo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/students")
    public List<StudentEntity>getStudents(){
        return studentRepo.findAll();
    }
    @GetMapping("/companies")
    public List<CompanyEntity>getCompanies(){
        return companyRepo.findAll();
    }
    @PostMapping("/addStudent")
    public String addStudent(@Valid @RequestBody RegisterRequest request){
        if (userRepository.findByEmail(request.getEmail()) !=null){
            return "Email already exists";
        }
        UserEntity user=new UserEntity();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_STUDENT);
        userRepository.save(user);
        return "Student Added Successfully";
    }
    @PostMapping("/addCompany")
    public String addCompany(@Valid @RequestBody RegisterRequest request){
        if (userRepository.findByEmail(request.getEmail())!=null){
            return "Email already exists";
        }
        UserEntity user=new UserEntity();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_COMPANY);
        userRepository.save(user);
        return "Company Added Successfully";
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "Student deleted";
    }
    @DeleteMapping("/company/{id}")
    public String deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
        return "Company deleted";
    }
}
