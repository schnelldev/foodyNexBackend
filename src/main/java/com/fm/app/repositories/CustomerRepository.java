package com.fm.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fm.app.entities.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer>{
	
}
