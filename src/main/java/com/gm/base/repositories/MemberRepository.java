package com.gm.base.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gm.base.entities.Member;

public interface MemberRepository extends MongoRepository<Member, String>{
	public List<Member> findByClientId(String clientId);
	public List<Member> findByClientIdAndMembershipStartDateGreaterThanEqual(String clientId,LocalDate localDate);
	public int countByClientIdAndMembershipStartDateGreaterThanEqual(String clientId,LocalDate localDate);
}
