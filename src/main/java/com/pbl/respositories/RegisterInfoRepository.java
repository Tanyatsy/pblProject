package com.pbl.respositories;

import com.pbl.models.RegisterInfo;
import com.pbl.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterInfoRepository extends JpaRepository<RegisterInfo, Long> {
    List<RegisterInfo> findByStudent(Student student);
}
