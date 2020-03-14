package com.gm.base.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gm.base.enums.OfferType;

@Document
public class Offer {
	
	@Transient
	public static final String SEQUENCE_NAME = "offer_sequence";
	
	@Id
	Integer offerId;
	String offerName;
	List<Plan> eligiblePackages;
	OfferType offerType;
	Date startDate;
	Date endDate;
	String clientId;
	Integer offerUnit;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Integer getOfferUnit() {
		return offerUnit;
	}

	public void setOfferUnit(Integer offerUnit) {
		this.offerUnit = offerUnit;
	}

	boolean active;

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public List<Plan> getEligiblePackages() {
		return eligiblePackages;
	}

	public void setEligiblePackages(List<Plan> eligiblePackages) {
		this.eligiblePackages = eligiblePackages;
	}

	public OfferType getOfferType() {
		return offerType;
	}

	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
