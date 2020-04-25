package com.fm.app.entities;

import java.util.Date;

public class CartItem {
	MenuVariant menuVariant;
	int qty;
	Date addedDate;

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

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
}
