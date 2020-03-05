package com.gm.base.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gm.base.entities.MembershipPackage;

public interface MembershipPackageRepository extends MongoRepository<MembershipPackage, Integer>{
	public List<MembershipPackage> findByClientId(String clientId);
}
