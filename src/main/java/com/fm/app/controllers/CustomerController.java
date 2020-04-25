package com.fm.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fm.app.entities.Customer;
import com.fm.app.repositories.CustomerRepository;
import com.fm.app.services.SequenceGeneratorService;

@RestController
@RequestMapping("api/customers")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

	@PostMapping
	public String create(@RequestBody Customer customer) {
		customer.setCutomerId(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME));
		customerRepository.save(customer);
		return "success";
	}
	
	@GetMapping
	public List<Customer> getAll(){
		return customerRepository.findAll();
	}
}
