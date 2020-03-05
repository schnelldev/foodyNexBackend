package com.gm.base.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gm.base.entities.Trainer;

public interface TrainerRepository extends MongoRepository<Trainer, String>{
	public List<Trainer> findByClientId(String clientId);
}
