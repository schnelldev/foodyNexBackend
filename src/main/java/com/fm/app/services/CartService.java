package com.fm.app.services;

import com.fm.app.entities.Cart;
import com.fm.app.exceptions.InvalidClientException;

public interface CartService {
	public Cart addToCart(Cart cart) throws InvalidClientException;
}
