package com.gm.base.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gm.base.enums.UserType;

@Document
public class User {
	
	 @Transient
	 public static final String MEMBER_SEQUENCE_NAME = "member_sequence";
	 
	 @Transient
	 public static final String STAFF_SEQUENCE_NAME = "staff_sequence";
	 
	 @Transient
	 public static final String TRAINER_SEQUENCE_NAME = "trainer_sequence";
	
	@Id
	String userId;
	String userName;
	String phoneNo;
	String hashedPassword;
	UserType userType;
	String gender;
	String clientId;
	boolean active;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}