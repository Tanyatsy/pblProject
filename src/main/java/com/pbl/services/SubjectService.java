package com.pbl.services;

import com.pbl.models.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    List<Subject> findAllSubjects();

    Optional<Subject> findById(int id);

}
