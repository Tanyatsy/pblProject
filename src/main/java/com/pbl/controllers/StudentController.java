package com.pbl.controllers;


import com.pbl.models.Student;
import com.pbl.services.serviceimpl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class StudentController{

    private final StudentServiceImpl studentServiceImpl;


    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentServiceImpl.findAllStudents();
    }


    @GetMapping("/student/{studentId}")
    public Optional<Student> findById(int studentId) {
        return studentServiceImpl.findById(studentId);
    }



}
