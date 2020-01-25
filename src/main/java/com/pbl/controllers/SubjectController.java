package com.pbl.controllers;

import com.pbl.models.Subject;
import com.pbl.services.serviceimpl.SubjectServiceImpl;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class SubjectController {
	
	@Autowired
    private SubjectServiceImpl subjectServiceImpl;
    @GetMapping("/subjects")
    public List<Subject> findAllSubjects() {
        return subjectServiceImpl.findAllSubjects();
    }


    @GetMapping("/subjects/{subjectId}")
    public Optional<Subject> findById(@PathVariable int subjectId) {
        return subjectServiceImpl.findById(subjectId);
    }

    @GetMapping("/subjects/calculateAmountOfLessons/{subjectId}")
    public List<Integer> calculateAmountOfLessons(@PathVariable int subjectId){
        Subject subject = subjectServiceImpl.findById(subjectId).get();
        List<Integer> nrOfLessons = Collections.singletonList(subject.getNrOfLessons());
        return nrOfLessons;
    }
}
