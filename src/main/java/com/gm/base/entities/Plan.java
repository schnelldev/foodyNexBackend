package com.gm.base.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gm.base.enums.MembershipType;

@Document
public class Plan {
	
	@Transient
	public static final String SEQUENCE_NAME = "plan_sequence";
	
	@Id
	Integer planId;
	String planName;
	MembershipType membershipType;
	int frequencyInMonth;
	String description;
	public List<GymnexClass> availableClasses;
	boolean planDiscountAvailable;
	int planDiscount;
	boolean productDiscountAvailable;
	int productDiscount;
	String clientId;
	int membershipAmount;

	public int getMembershipAmount() {
		return membershipAmount;
	}

	public void setMembershipAmount(int membershipAmount) {
		this.membershipAmount = membershipAmount;
	}

	public String getClientId() {
		return clientId;
	}

	public MembershipType getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(MembershipType membershipType) {
		this.membershipType = membershipType;
	}

	public int getFrequencyInMonth() {
		return frequencyInMonth;
	}

	public void setFrequencyInMonth(int frequencyInMonth) {
		this.frequencyInMonth = frequencyInMonth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<GymnexClass> getAvailableClasses() {
		return availableClasses;
	}

	public void setAvailableClasses(List<GymnexClass> availableClasses) {
		this.availableClasses = availableClasses;
	}

	public boolean isPlanDiscountAvailable() {
		return planDiscountAvailable;
	}

	public void setPlanDiscountAvailable(boolean planDiscountAvailable) {
		this.planDiscountAvailable = planDiscountAvailable;
	}

	public int getPlanDiscount() {
		return planDiscount;
	}

	public void setPlanDiscount(int planDiscount) {
		this.planDiscount = planDiscount;
	}

	public boolean isProductDiscountAvailable() {
		return productDiscountAvailable;
	}

	public void setProductDiscountAvailable(boolean productDiscountAvailable) {
		this.productDiscountAvailable = productDiscountAvailable;
	}

	public int getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

}