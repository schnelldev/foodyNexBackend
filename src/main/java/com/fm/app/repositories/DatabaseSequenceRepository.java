package com.fm.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fm.app.entities.DatabaseSequence;

@Repository
public interface DatabaseSequenceRepository extends MongoRepository<DatabaseSequence, String>{

}
