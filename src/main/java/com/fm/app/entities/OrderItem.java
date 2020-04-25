package com.fm.app.entities;

import java.util.Date;

public class OrderItem {
	
	MenuVariant menuVariant;
	int qty;
	Date createdDate;
	
	public MenuVariant getMenuVariant() {
		return menuVariant;
	}
	public void setMenuVariant(MenuVariant menuVariant) {
		this.menuVariant = menuVariant;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
