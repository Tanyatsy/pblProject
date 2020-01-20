package com.pbl.services.serviceimpl;

import com.pbl.models.Student;
import com.pbl.respositories.StudentRepository;
import com.pbl.services.StudentService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public ResponseEntity<Object> createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .build(savedStudent.getStudentId());

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Object> updateStudent(Student student, int id) throws Exception {
        Optional.ofNullable(studentRepository.findById(id)
                .map(person1 -> {
                            log.info("Post with personId = '{}' faunded.", id);
                            student.setStudentId(id);
                            studentRepository.save(student);
                            log.info("person updated:{}",student);
                            return student;
                        }
                ).orElseThrow(() -> new Exception("There is student with such id " + id)));
        return ResponseEntity.noContent().build();
    }
}
