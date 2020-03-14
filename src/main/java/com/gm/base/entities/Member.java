package com.gm.base.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.gm.base.enums.MemberType;

public class Member extends User{
	
	
	int trialDays;
	String purpose;
	String photoUrl;
	Integer weight;
	Integer height;
	String biometricId;
	LocalDate membershipStartDate;
	LocalDate membershipEndDate;
	
	MemberType memberType;
	
	Plan plan;
	List<GymnexClass> classes = new ArrayList<>();
	//Plan membershipPackage;
	User trainer;
	List<Transaction> transactions = new ArrayList<>();
	List<RegimeDay> regimeDays = new ArrayList<>();
	DietStructure dietStructure;

//	public Plan getMembershipPackage() {
//		return membershipPackage;
//	}
//
//	public void setMembershipPackage(Plan membershipPackage) {
//		this.membershipPackage = membershipPackage;
//	}

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


	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	public List<GymnexClass> getClasses() {
		return classes;
	}

	public void setClasses(List<GymnexClass> classes) {
		this.classes = classes;
	}

	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	public int getTrialDays() {
		return trialDays;
	}

	public void setTrialDays(int trialDays) {
		this.trialDays = trialDays;
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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
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
