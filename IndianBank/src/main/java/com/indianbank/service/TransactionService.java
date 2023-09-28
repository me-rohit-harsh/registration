package com.indianbank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indianbank.entity.Transactions;
import com.indianbank.repository.TransactionRepository;

@Service
public class TransactionService {
	private TransactionRepository transactionRepository;

	public TransactionService(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}

	public Transactions saveTransaction(Transactions transaction) {
		return transactionRepository.save(transaction);
	}

	public List<Transactions> allTransactions() {
		return transactionRepository.findAll();
	}
}
