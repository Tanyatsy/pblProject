package com.pbl.controllers;

import com.pbl.models.RegisterInfo;
import com.pbl.models.Student;
import com.pbl.services.serviceimpl.RegisterInfoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class RegisterInfoController {

    private final RegisterInfoServiceImpl registerInfoServiceImpl;


    @GetMapping("/registerinfo")
    public List<RegisterInfo> findByStudent() {
        return registerInfoServiceImpl.findAllRegisterInfo();
    }


    @GetMapping("/registerinfo/{studentId}")
    public List<RegisterInfo> findByStudent(Student studentId) {
        return registerInfoServiceImpl.findByStudent(studentId);
    }



}
