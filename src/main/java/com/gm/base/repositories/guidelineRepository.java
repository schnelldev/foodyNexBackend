package com.gm.base.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gm.base.entities.Guideline;

public interface guidelineRepository extends MongoRepository<Guideline, Integer> {

}
