package com.fm.app.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Cart {

	@Id
	int cartId;
	int customerId;
	List<CartItem> cartItems = new ArrayList<>();

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

}
