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
	
	CustomerRepository customerRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Override
	public String addOrder(Order order) throws InvalidClientException,InvalidCustomerException {
		String result = "";
		if(!clientRepository.existsById(order.getClientId())) {
			throw new InvalidClientException();
		}else if(customerRepository.existsById(order.getCustomerId())){
			throw new InvalidCustomerException();
		}else {
			order.setOrderId(sequenceGeneratorService.generateSequence(Order.SEQUENCE_NAME));
			Order o = orderRepository.save(order);
			result = String.valueOf(o.getOrderId());
		}
		return result;
	}
}