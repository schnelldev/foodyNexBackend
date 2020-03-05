package com.gm.base.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gm.base.entities.ClientSeqPrefix;

@Repository
public interface ClientSeqPrefixRepository extends MongoRepository<ClientSeqPrefix,String>{
	
}
