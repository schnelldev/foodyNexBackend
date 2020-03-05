package com.gm.base.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Plan {
	
	 @Transient
	 public static final String SEQUENCE_NAME = "plan_sequence";

	@Id
	Integer planId;
	Date planBuyDate;
	String planName;
	String clientId;
	String planDesc;
	List<String> activities; 

	public List<String> getActivities() {
		return activities;
	}

	public void setActivities(List<String> activities) {
		this.activities = activities;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanDesc() {
		return planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Date getPlanBuyDate() {
		return planBuyDate;
	}

	public void setPlanBuyDate(Date planBuyDate) {
		this.planBuyDate = planBuyDate;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}
