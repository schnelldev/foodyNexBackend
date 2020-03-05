package com.gm.base.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member extends User{

	List<Plan> plan;
	MembershipPackage membershipPackage;
	Integer weight;
	Integer height;
	String purpose;
	User trainer;
	String photoUrl;
	List<Transaction> transactions = new ArrayList<>();
	List<RegimeDay> regimeDays = new ArrayList<>();
	String biometricId;
	DietStructure dietStructure;
	LocalDate membershipStartDate;
	LocalDate membershipEndDate;

	public MembershipPackage getMembershipPackage() {
		return membershipPackage;
	}

	public void setMembershipPackage(MembershipPackage membershipPackage) {
		this.membershipPackage = membershipPackage;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<RegimeDay> getRegimeDays() {
		return regimeDays;
	}

	public void setRegimeDays(List<RegimeDay> regimeDays) {
		this.regimeDays = regimeDays;
	}

	public List<Plan> getPlan() {
		return plan;
	}

	public void setPlan(List<Plan> plan) {
		this.plan = plan;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public String getBiometricId() {
		return biometricId;
	}

	public void setBiometricId(String biometricId) {
		this.biometricId = biometricId;
	}

	public DietStructure getDietStructure() {
		return dietStructure;
	}

	public void setDietStructure(DietStructure dietStructure) {
		this.dietStructure = dietStructure;
	}
	
	public LocalDate getMembershipStartDate() {
		return membershipStartDate;
	}

	public void setMembershipStartDate(LocalDate membershipStartDate) {
		this.membershipStartDate = membershipStartDate;
	}

	public LocalDate getMembershipEndDate() {
		return membershipEndDate;
	}

	public void setMembershipEndDate(LocalDate membershipEndDate) {
		this.membershipEndDate = membershipEndDate;
	}

}
