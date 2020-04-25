package com.fm.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fm.app.entities.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>{

}
