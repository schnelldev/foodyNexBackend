package com.fm.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.app.entities.Order;
import com.fm.app.services.OrderService;

@RestController
@RequestMapping("api/orders")
@CrossOrigin
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	public ResponseEntity<String> addOrder(@RequestBody Order order) {
		String result = "";
		try {
			result = orderService.addOrder(order);
		}catch(Exception exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
