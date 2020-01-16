package com.pbl.services;

import com.pbl.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAllStudents();

    Optional<Student> findById(int id);



}
