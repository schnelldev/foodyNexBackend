package com.gm.base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gm.base.entities.Transaction;
import com.gm.base.services.TransactionService;

@RestController
@RequestMapping("api/transactions")
@CrossOrigin
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	@PostMapping
	public void add(@RequestBody Transaction transaction) {
		transactionService.add(transaction);
	}
}
