package com.pbl.services;


import com.pbl.models.Teacher;
import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> findAllTeachers();

    Optional<Teacher> findById(int id);

}
