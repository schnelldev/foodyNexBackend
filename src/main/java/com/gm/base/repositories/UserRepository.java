package com.gm.base.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gm.base.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	public Optional<User> findByUserName(String userName);
}
