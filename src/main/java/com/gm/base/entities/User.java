package com.gm.base.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gm.base.enums.Gender;
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
	String photoName;
	String firstName;
	String lastName;
	String phoneNo;
	String hashedPassword;
	UserType userType;
	Gender gender;
	String clientId;
	boolean active;
	long aadharNo;
	String pan;
	String emergencyPhNo;
	String emergencyPersonName;
	String email;
	String address;
	String city;
	String state;
	int zipCode;
	String country;
	Date dob;

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

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getEmergencyPhNo() {
		return emergencyPhNo;
	}

	public void setEmergencyPhNo(String emergencyPhNo) {
		this.emergencyPhNo = emergencyPhNo;
	}

	public String getEmergencyPersonName() {
		return emergencyPersonName;
	}

	public void setEmergencyPersonName(String emergencyPersonName) {
		this.emergencyPersonName = emergencyPersonName;
	}
}