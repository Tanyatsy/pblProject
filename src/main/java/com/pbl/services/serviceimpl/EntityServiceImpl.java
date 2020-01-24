package com.pbl.services.serviceimpl;

import com.pbl.models.Entity;
import com.pbl.models.Student;
import com.pbl.respositories.EntityRepository;
import com.pbl.respositories.StudentRepository;
import com.pbl.services.EntityService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EntityServiceImpl implements EntityService {

	@Autowired
    private EntityRepository entityRepository;

    @Override
    public List<Entity> findAllEntities() {
        return entityRepository.findAll();
    }

    @Override
    public Optional<Entity> findById(int id) {
        return Optional.empty();
    }




}

