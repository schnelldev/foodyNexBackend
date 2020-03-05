package com.gm.base.entities;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.List;

public class TrainerAvailability {
	List<DayOfWeek> dayOfWeeks;
	Time startTime; 
	Time endTime;
	
	public List<DayOfWeek> getDayOfWeeks() {
		return dayOfWeeks;
	}
	public void setDayOfWeeks(List<DayOfWeek> dayOfWeeks) {
		this.dayOfWeeks = dayOfWeeks;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
}
