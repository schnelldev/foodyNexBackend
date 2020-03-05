package com.gm.base.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gm.base.entities.Plan;

@Repository
public interface PlanRepository extends MongoRepository<Plan, Integer> {
	public List<Plan> findByClientId(String clientId);
}
