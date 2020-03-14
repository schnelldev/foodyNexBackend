package com.gm.base.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gm.base.entities.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{
	public List<Product> findByClientId(String clientId);
}
