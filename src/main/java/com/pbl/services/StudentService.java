package com.pbl.services;

import com.pbl.models.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAllStudents();

    Optional<Student> findById(int id);

    ResponseEntity<Object> createStudent(Student student);

    ResponseEntity<Object> updateStudent(Student student, int id) throws Exception;



}
