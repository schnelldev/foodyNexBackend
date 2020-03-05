package com.gm.base.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trainer extends User{

	List<String> specializations = new ArrayList<>();
	TrainerAvailability availability;
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

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}
}
