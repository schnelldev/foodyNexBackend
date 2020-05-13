package com.fm.app.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fm.app.entities.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, Integer>{
	public Optional<Client> findByUserName(String userName);
}
