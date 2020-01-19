package com.pbl.controllers;

import com.pbl.models.Teacher;
import com.pbl.services.serviceimpl.TeacherServiceImpl;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class TeacherController {
	
	@Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @GetMapping("/teachers")
    public List<Teacher> findAllTeachers() {
        return teacherServiceImpl.findAllTeachers();
    }


    @GetMapping("/teachers/{teacherId}")
    public Optional<Teacher> findById(@PathVariable int teacherId) {
        return teacherServiceImpl.findById(teacherId);
    }
}

