package com.pbl.services.serviceimpl;

import com.pbl.models.RegisterInfo;
import com.pbl.models.Student;
import com.pbl.respositories.RegisterInfoRepository;
import com.pbl.services.RegisterInfoService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegisterInfoServiceImpl implements RegisterInfoService {

	@Autowired
    private RegisterInfoRepository registerInfoRepository;

    @Override
    public List<RegisterInfo> findAllRegisterInfo() {
        return registerInfoRepository.findAll();
    }

    public List<RegisterInfo> findByStudent(Student id) {
        return registerInfoRepository.findByStudent(id);
    }
}
