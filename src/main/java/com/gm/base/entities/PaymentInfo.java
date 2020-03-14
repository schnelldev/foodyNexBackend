package com.gm.base.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class PaymentInfo {
	
	int paymentId;
	int price;
	int taxPercent;
	int taxAmount;
	int discount;
	int totalAmount;
	int amountPaid;
	int amountDue;
	Date amountDueDate;
	
	
}
