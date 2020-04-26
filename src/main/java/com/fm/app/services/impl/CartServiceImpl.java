package com.fm.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.fm.app.entities.Cart;
import com.fm.app.exceptions.InvalidClientException;
import com.fm.app.repositories.CartRepository;
import com.fm.app.repositories.ClientRepository;
import com.fm.app.services.CartService;

public class CartServiceImpl implements CartService{

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	CartRepository cartRepository; 
	
	@Override
	public Cart addToCart(Cart cart) throws InvalidClientException {
		if(!clientRepository.existsById(cart.getClientId())) {
			throw new InvalidClientException();
		}else{
			cart = cartRepository.save(cart);
		}
		return cart;
	}
}
