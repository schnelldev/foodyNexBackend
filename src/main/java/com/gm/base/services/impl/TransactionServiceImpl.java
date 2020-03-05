package com.gm.base.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.base.entities.Transaction;
import com.gm.base.repositories.TransactionRepository;
import com.gm.base.services.SequenceGeneratorService;
import com.gm.base.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Override
	public void add(Transaction transaction) {
		transaction.setTransactionId(sequenceGeneratorService.generateSequence(Transaction.SEQUENCE_NAME));
		transactionRepository.save(transaction);
	}
}