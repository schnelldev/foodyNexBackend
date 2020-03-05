package com.gm.base.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gm.base.entities.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, Integer>{

}
