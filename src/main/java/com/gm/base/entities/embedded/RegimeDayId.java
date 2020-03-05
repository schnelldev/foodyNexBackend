package com.gm.base.entities.embedded;

import java.io.Serializable;
import java.time.DayOfWeek;

public class RegimeDayId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private DayOfWeek dayOfWeek;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
}
