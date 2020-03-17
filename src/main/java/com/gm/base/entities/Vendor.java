package com.gm.base.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vendor {
	
	@Transient
	public static final String SEQUENCE_NAME = "vendor_sequence";
	
	@Id
	int vendorId;
	String vendorPhotoUrl;
	String vendorName;
	String vendorAddress;
	String city;
	String state;
	int zipcode;
	String country;
	String gstNo;
	String panCardNo;
	String productType;
	String productName;
	boolean active;
	
	String contactName;
	String contactNo;
	String emailId;
	
	String supportContactNo;
	String supportEmailId;
	boolean hasWebsite;
	String website;
	
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorPhotoUrl() {
		return vendorPhotoUrl;
	}
	public void setVendorPhotoUrl(String vendorPhotoUrl) {
		this.vendorPhotoUrl = vendorPhotoUrl;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
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
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getPanCardNo() {
		return panCardNo;
	}
	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSupportContactNo() {
		return supportContactNo;
	}
	public void setSupportContactNo(String supportContactNo) {
		this.supportContactNo = supportContactNo;
	}
	public String getSupportEmailId() {
		return supportEmailId;
	}
	public void setSupportEmailId(String supportEmailId) {
		this.supportEmailId = supportEmailId;
	}
	public boolean isHasWebsite() {
		return hasWebsite;
	}
	public void setHasWebsite(boolean hasWebsite) {
		this.hasWebsite = hasWebsite;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
}
