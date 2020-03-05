package com.gm.base.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MembershipPackage {
	
	@Transient
	public static final String SEQUENCE_NAME = "membership_package_sequence";
	
	@Id
	Integer membershipPackageId;
	String typeName;
	String clientId;
	int dayCount;
	Offer offer;
	int membershipAmount;

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Integer getMembershipPackageId() {
		return membershipPackageId;
	}

	public void setMembershipPackageId(Integer membershipPackageId) {
		this.membershipPackageId = membershipPackageId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getDayCount() {
		return dayCount;
	}

	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}

	public int getMembershipAmount() {
		return membershipAmount;
	}

	public void setMembershipAmount(int membershipAmount) {
		this.membershipAmount = membershipAmount;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}