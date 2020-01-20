package com.pbl.controllers;


import com.pbl.models.Student;
import com.pbl.services.serviceimpl.StudentServiceImpl;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class StudentController{

	@Autowired
    private StudentServiceImpl studentServiceImpl;


    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentServiceImpl.findAllStudents();
    }


    @GetMapping("/student/{studentId}")
    public Optional<Student> findById(@PathVariable int studentId) {
        return studentServiceImpl.findById(studentId);
    }

    @PostMapping("students/create")
    public ResponseEntity<Object> createStudent(@RequestBody Student student){
        return studentServiceImpl.createStudent(student);
    }

    @PutMapping("students/update/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student,@PathVariable int id) throws Exception{
        return studentServiceImpl.updateStudent(student,id);
    }



}
