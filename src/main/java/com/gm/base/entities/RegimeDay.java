package com.gm.base.entities;

import java.time.DayOfWeek;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RegimeDay {
	
	DayOfWeek dayOfWeek;
	String regimeText;
	String regimeName;
	String exercise;
	int set;
	int repititions;

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getRegimeText() {
		return regimeText;
	}

	public void setRegimeText(String regimeText) {
		this.regimeText = regimeText;
	}

	public String getRegimeName() {
		return regimeName;
	}

	public void setRegimeName(String regimeName) {
		this.regimeName = regimeName;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public int getSet() {
		return set;
	}

	public void setSet(int set) {
		this.set = set;
	}

	public int getRepititions() {
		return repititions;
	}

	public void setRepititions(int repititions) {
		this.repititions = repititions;
	}
}
