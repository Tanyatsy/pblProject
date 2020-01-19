package com.pbl.services.serviceimpl;

import com.pbl.models.Teacher;
import com.pbl.respositories.TeacherRepository;
import com.pbl.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    @Override
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(int id) {
        return teacherRepository.findById(id);
    }
}
