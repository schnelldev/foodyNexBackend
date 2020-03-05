package com.gm.base.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gm.base.entities.Equipment;

@Repository
public interface EquipmentRepository extends MongoRepository<Equipment, Integer> {
   public List<Equipment> findByClientId(String clientId); 
}
