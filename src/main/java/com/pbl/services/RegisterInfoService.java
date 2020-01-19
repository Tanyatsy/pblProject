package com.pbl.services;

import com.pbl.models.RegisterInfo;
import com.pbl.models.Student;

import java.util.List;

public interface RegisterInfoService {

    List<RegisterInfo> findAllRegisterInfo();

    List<RegisterInfo> findByStudent(Student id);
}
