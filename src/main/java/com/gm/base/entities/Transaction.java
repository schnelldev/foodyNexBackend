package com.gm.base.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gm.base.enums.PaymentType;
import com.gm.base.enums.TransactionMode;
import com.gm.base.enums.TransactionType;

@Document
public class Transaction {

	@Transient
	public static final String SEQUENCE_NAME = "transaction_sequence";
	
	@Id
	Integer transactionId;
	String transactionRemark;
	TransactionType transactionType;
	PaymentType paymentType;
	TransactionMode mode;
	Date transactionDate;
	String userId;
	Integer paymentRecieved;
	Integer paymentPending;
	Date pendingRecieveDate;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionRemark() {
		return transactionRemark;
	}

	public void setTransactionRemark(String transactionRemark) {
		this.transactionRemark = transactionRemark;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getPaymentRecieved() {
		return paymentRecieved;
	}

	public void setPaymentRecieved(Integer paymentRecieved) {
		this.paymentRecieved = paymentRecieved;
	}

	public Integer getPaymentPending() {
		return paymentPending;
	}

	public void setPaymentPending(Integer paymentPending) {
		this.paymentPending = paymentPending;
	}

	public Date getPendingRecieveDate() {
		return pendingRecieveDate;
	}

	public void setPendingRecieveDate(Date pendingRecieveDate) {
		this.pendingRecieveDate = pendingRecieveDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public TransactionMode getMode() {
		return mode;
	}

	public void setMode(TransactionMode mode) {
		this.mode = mode;
	}

}
