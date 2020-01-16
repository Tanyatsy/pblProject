package com.pbl.controllers;

import com.pbl.models.Entity;
import com.pbl.models.Student;
import com.pbl.services.serviceimpl.EntityServiceImpl;
import com.pbl.services.serviceimpl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@AllArgsConstructor
public class EntityController {

    private final EntityServiceImpl entityServiceImpl;

    @GetMapping("/entities")
    public List<Entity> findAllEntities() {
        return entityServiceImpl.findAllEntities();
    }


}
