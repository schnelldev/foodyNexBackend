package com.gm.base.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gm.base.entities.Staff;

public interface StaffRepository extends MongoRepository<Staff,String>{
	public List<Staff> findByClientId(String clientId);
}
