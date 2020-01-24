package com.pbl.services.serviceimpl;

import com.pbl.models.RegisterInfo;
import com.pbl.models.Student;
import com.pbl.respositories.RegisterInfoRepository;
import com.pbl.services.RegisterInfoService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
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

    @Override
    public ResponseEntity<Object> updateRegisterInfo(RegisterInfo registerInfo, long id) throws Exception {
        Optional.ofNullable(registerInfoRepository.findById(id)
                .map(person1 -> {
                            log.info("Post with personId = '{}' faunded.", id);
                            registerInfo.setId((int) id);
                            registerInfoRepository.save(registerInfo);
                            log.info("person updated:{}",registerInfo);
                            return registerInfo;
                        }
                ).orElseThrow(() -> new Exception("There is no entity with such id " + id)));
        return ResponseEntity.noContent().build();
    }

}
