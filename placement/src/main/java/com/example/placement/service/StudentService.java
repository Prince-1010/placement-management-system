package com.example.placement.service;

import com.example.placement.entity.StudentEntity;
import com.example.placement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public StudentEntity saveStudent(StudentEntity student){
        return studentRepository.save(student);
    }
    public List<StudentEntity>getAllStudents(){
        return studentRepository.findAll();
    }
    public StudentEntity getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
