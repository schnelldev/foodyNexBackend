package com.fm.app.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fm.app.enums.OrderStatus;
import com.fm.app.enums.PaymentMode;

@Document
public class Order {

	@Id
	int orderId;
	int customerId;
	List<OrderItem> orderItems = new ArrayList<>();
	boolean discountApplicable;
	int discount;
	int tax;
	int deliveryFees;
	int finalAmount;
	Date orderDate;
	PaymentMode paymentMode;
	OrderStatus orderStatus;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public boolean isDiscountApplicable() {
		return discountApplicable;
	}

	public void setDiscountApplicable(boolean discountApplicable) {
		this.discountApplicable = discountApplicable;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(int finalAmount) {
		this.finalAmount = finalAmount;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public int getDeliveryFees() {
		return deliveryFees;
	}

	public void setDeliveryFees(int deliveryFees) {
		this.deliveryFees = deliveryFees;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
