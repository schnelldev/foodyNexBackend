package com.fm.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.app.entities.Cart;
import com.fm.app.services.CartService;

@RestController
@RequestMapping("api/carts")
@CrossOrigin
public class CartController {
	
	@Autowired
	CartService cartService;

	public ResponseEntity<Object> addToCart(@RequestBody Cart cart){
		try {
			return new ResponseEntity<>(cartService.addToCart(cart),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
}
