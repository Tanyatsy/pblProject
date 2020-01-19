package com.pbl.controllers;

import com.pbl.models.Student;
import com.pbl.models.Subject;
import com.pbl.services.serviceimpl.SubjectServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class SubjectController {
    private final SubjectServiceImpl subjectServiceImpl;
    @GetMapping("/subjects")
    public List<Subject> findAllSubjects() {
        return subjectServiceImpl.findAllSubjects();
    }


    @GetMapping("/subjects/{subjectId}")
    public Optional<Subject> findById(int subjectId) {
        return subjectServiceImpl.findById(subjectId);
    }
}
