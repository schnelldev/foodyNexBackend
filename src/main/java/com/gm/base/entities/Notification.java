package com.gm.base.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gm.base.enums.UserType;

@Document
public class Notification {
	
	@Id
	Integer notificationId;
	String notificationText;
	Date date;
	UserType userType;
	UserType sentFrom;
}
