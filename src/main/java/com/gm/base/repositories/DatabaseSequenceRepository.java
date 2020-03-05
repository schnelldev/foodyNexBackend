package com.gm.base.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gm.base.entities.DatabaseSequence;

@Repository
public interface DatabaseSequenceRepository extends MongoRepository<DatabaseSequence, String>{

}
