package com.example.placement.controller;

import com.example.placement.entity.StudentEntity;
import com.example.placement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentEntity addStudent(@RequestBody StudentEntity student){
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<StudentEntity> getStudents(){
        return studentService.getAllStudents();
    }
}
