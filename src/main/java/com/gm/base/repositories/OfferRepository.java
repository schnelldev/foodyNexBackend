package com.gm.base.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gm.base.entities.Offer;

@Repository
public interface OfferRepository extends MongoRepository<Offer, Integer>{
	public List<Offer> findByClientId(String clientId);
}