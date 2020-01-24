package com.pbl.controllers;

import com.pbl.models.RegisterInfo;
import com.pbl.models.Student;
import com.pbl.services.serviceimpl.RegisterInfoServiceImpl;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class RegisterInfoController {

	@Autowired
    private RegisterInfoServiceImpl registerInfoServiceImpl;
	
	@Autowired
	private StudentController studentHandler;


    @GetMapping("/registerinfo")
    public List<RegisterInfo> findByStudent() {
        return registerInfoServiceImpl.findAllRegisterInfo();
    }


    @GetMapping("/registerinfo/{studentId}")
    public List<RegisterInfo> findByStudent(@PathVariable int studentId) {
    	Student student = studentHandler.findById(studentId).get();
        return registerInfoServiceImpl.findByStudent(student);
    }

    @PutMapping("/registerinfo/update/{id}")
    public ResponseEntity<Object> updateRegisterInfo(@RequestBody RegisterInfo registerInfo, @PathVariable int id) throws Exception{
        return registerInfoServiceImpl.updateRegisterInfo(registerInfo,id);
    }



}
