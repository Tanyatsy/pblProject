package com.pbl.services;

import com.pbl.models.RegisterInfo;
import com.pbl.models.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RegisterInfoService {

    List<RegisterInfo> findAllRegisterInfo();

    List<RegisterInfo> findByStudent(Student id);

    ResponseEntity<Object> updateRegisterInfo(RegisterInfo registerInfo, long id) throws Exception;
}
