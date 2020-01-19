package com.pbl.services.serviceimpl;

import com.pbl.models.Student;
import com.pbl.models.Subject;
import com.pbl.respositories.StudentRepository;
import com.pbl.respositories.SubjectRepository;
import com.pbl.services.SubjectService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {
	@Autowired
    private SubjectRepository subjectRepository;
    @Override
    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(int id) {
        return subjectRepository.findById(id);
    }
}
