package com.gm.base.repositories;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators.In;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.gm.base.entities.PostOffice;

public interface PostOfficeRepository extends MongoRepository<PostOffice, Integer> {

}
