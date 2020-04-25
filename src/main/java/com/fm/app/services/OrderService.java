package com.fm.app.services;

import com.fm.app.entities.Order;
import com.fm.app.exceptions.InvalidClientException;
import com.fm.app.exceptions.InvalidCustomerException;

public interface OrderService {
	public String addOrder(Order order) throws InvalidClientException,InvalidCustomerException;
}
