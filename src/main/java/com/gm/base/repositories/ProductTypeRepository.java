package com.gm.base.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gm.base.entities.ProductType;

@Repository
public interface ProductTypeRepository extends MongoRepository<ProductType, Integer> {
	public List<ProductType> findByClientId(String clientId);
}
