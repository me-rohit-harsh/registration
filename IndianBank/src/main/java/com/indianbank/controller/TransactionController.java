package com.indianbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.indianbank.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transaction")
	public String transaction(Model model) {
		model.addAttribute("transactions", transactionService.allTransactions());
		return "transaction";
	}

}
