package com.gm.base.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trainer extends User{
	
	int trainerId;
	String trainerPhotoUrl;
	List<String> specializations = new ArrayList<>();
	TrainerAvailability availability;
	int memberLimit;
	int salary;
	boolean productDiscount;
	int discountAmount;
	int noOfProductsDiscounted;
	String productType;
	Date doj;
	
	public TrainerAvailability getAvailability() {
		return availability;
	}

	public void setAvailability(TrainerAvailability availability) {
		this.availability = availability;
	}

	public List<String> getSpecializations() {
		return specializations;
	}

	public void setSpecializations(List<String> specializations) {
		this.specializations = specializations;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerPhotoUrl() {
		return trainerPhotoUrl;
	}

	public void setTrainerPhotoUrl(String trainerPhotoUrl) {
		this.trainerPhotoUrl = trainerPhotoUrl;
	}

	public int getMemberLimit() {
		return memberLimit;
	}

	public void setMemberLimit(int memberLimit) {
		this.memberLimit = memberLimit;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(boolean productDiscount) {
		this.productDiscount = productDiscount;
	}

	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getNoOfProductsDiscounted() {
		return noOfProductsDiscounted;
	}

	public void setNoOfProductsDiscounted(int noOfProductsDiscounted) {
		this.noOfProductsDiscounted = noOfProductsDiscounted;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}
}
