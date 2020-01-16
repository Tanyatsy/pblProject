package com.pbl.services;

import com.pbl.models.Entity;


import java.util.List;
import java.util.Optional;

public interface EntityService {

    List<Entity> findAllEntities();

    Optional<Entity> findById(int id);

}
