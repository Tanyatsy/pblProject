package com.pbl.controllers;


import com.pbl.algorithm.KpiCalculator;
import com.pbl.models.Student;
import com.pbl.models.Subject;
import com.pbl.services.serviceimpl.StudentServiceImpl;
import com.pbl.services.serviceimpl.SubjectServiceImpl;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class StudentController{

   /* @Autowired
    private RegisterInfoController registerInfoHandler;*/

	@Autowired
    private StudentServiceImpl studentServiceImpl;

    @Autowired
    private SubjectServiceImpl subjectServiceImpl;

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentServiceImpl.findAllStudents();
    }

    @GetMapping("/students/calculateMark/{studentId}")
    public double calculateMark(@PathVariable int studentId){
        Student student = studentServiceImpl.findById(studentId).get();
        List<Integer> marks = student.getInfo().stream().map(p->p.mark).collect(Collectors.toList());
        return KpiCalculator.calculateAverageMark(marks);
    }

    @GetMapping("/students/calculateAbsence/{studentId}")
    public double calculateAmountOfAbsence(@PathVariable int studentId){
        Student student = studentServiceImpl.findById(studentId).get();
        List<Boolean> absence = student.getInfo().stream().map(p->p.absence).collect(Collectors.toList());
        return KpiCalculator.calculateAmountOfAbsence(absence);
    }

    @GetMapping("/students/calculateActivity/{studentId}")
    public double calculateAmountOfStudentActivity(@PathVariable int studentId){
        Student student = studentServiceImpl.findById(studentId).get();
        List<String> activity = student.getInfo().stream().map(p->p.activity).collect(Collectors.toList());
        return KpiCalculator.calculateActualActivityResult(activity);
    }

    @GetMapping("/student/{studentId}")
    public Optional<Student> findById(@PathVariable int studentId) {
        return studentServiceImpl.findById(studentId);
    }

    @PostMapping("students/create")
    public ResponseEntity<Object> createStudent(@RequestBody Student student){
        return studentServiceImpl.createStudent(student);
    }

    @PatchMapping(path = "students/update/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> updateStudent(@RequestBody final Student student,@PathVariable int id) throws Exception{
        return studentServiceImpl.updateStudent(student,id);
    }



}
