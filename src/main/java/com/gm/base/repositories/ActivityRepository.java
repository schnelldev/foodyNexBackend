package com.gm.base.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gm.base.entities.Activity;

public interface ActivityRepository extends MongoRepository<Activity, Integer>{

}
