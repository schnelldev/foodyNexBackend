package com.gm.base.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Activity {

	Integer activityId;
	String activityName;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
}
