package com.gm.base.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gm.base.enums.OrderStatus;

@Document
public class Order {
	
	@Id
	Integer orderId;
	Date orderDate;
	OrderStatus orderStatus;
	
	Product product;
	User customer;
	
}
