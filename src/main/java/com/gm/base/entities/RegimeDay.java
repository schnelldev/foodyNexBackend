package com.gm.base.entities;

import java.time.DayOfWeek;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RegimeDay {
	DayOfWeek dayOfWeek;
	String regimeText;

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
}
