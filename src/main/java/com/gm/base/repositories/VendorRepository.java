package com.gm.base.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gm.base.entities.Vendor;

public interface VendorRepository extends MongoRepository<Vendor, Integer> {

}
