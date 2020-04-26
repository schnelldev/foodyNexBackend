package com.fm.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fm.app.entities.Cart;

public interface CartRepository extends MongoRepository<Cart, Integer>{

}
