package com.fm.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.app.entities.Order;
import com.fm.app.exceptions.InvalidClientException;
import com.fm.app.exceptions.InvalidCustomerException;
import com.fm.app.repositories.ClientRepository;
import com.fm.app.repositories.CustomerRepository;
import com.fm.app.repositories.OrderRepository;
import com.fm.app.services.OrderService;
import com.fm.app.services.SequenceGeneratorService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Override
	public Order addOrder(Order order) throws InvalidClientException,InvalidCustomerException {
		if(!clientRepository.existsById(order.getClientId())) {
			throw new InvalidClientException();
		}else if(!customerRepository.existsById(order.getCustomerId())){
			throw new InvalidCustomerException();
		}else {
			order.setOrderId(sequenceGeneratorService.generateSequence(Order.SEQUENCE_NAME));
			order = orderRepository.save(order);
		}
		return order;
	}
}