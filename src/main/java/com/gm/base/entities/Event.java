package com.gm.base.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Event {
	
	String eventName;
	String eventDesc;
	Date startDate;
	Date endDate;
	LocalTime startTime;
	LocalTime endTime;
	boolean isChargeable;
	int price;
	int registrationLimit;
	ArrayList<String> eventPhotoNames;
	 
	
	
}
