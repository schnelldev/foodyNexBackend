package com.gm.base.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gm.base.entities.GymnexClass;

public interface GymnexClassRepository extends MongoRepository<GymnexClass, Integer> {

}
