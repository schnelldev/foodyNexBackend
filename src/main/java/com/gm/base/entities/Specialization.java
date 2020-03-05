package com.gm.base.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Specialization {

	private Integer specializationId;
	private String specializationName;

	public Integer getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(Integer specializationId) {
		this.specializationId = specializationId;
	}

	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}
}