package com.pbl.respositories;

import com.pbl.models.Entity;
import com.pbl.models.EntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityRepository extends JpaRepository<Entity, EntityId> {

}
