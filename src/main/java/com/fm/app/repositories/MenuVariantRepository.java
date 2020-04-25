package com.fm.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fm.app.entities.MenuVariant;

@Repository
public interface MenuVariantRepository extends MongoRepository<MenuVariant, Integer>{

}
