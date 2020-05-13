package com.fm.app.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fm.app.entities.DeliveryBoy;

@Repository
public interface DeliveryBoyRepository extends MongoRepository<DeliveryBoy, Integer> {
	public Optional<DeliveryBoy> findByUserName(String userName);
}
