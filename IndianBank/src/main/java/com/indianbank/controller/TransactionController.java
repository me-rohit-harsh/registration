package com.indianbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indianbank.entity.Transactions;
import com.indianbank.entity.User;
import com.indianbank.repository.TransactionRepository;
import com.indianbank.service.TransactionService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private TransactionRepository transactionRepository;

	@GetMapping("/transaction")
	public String transaction(@RequestParam(name = "transactionFilter", defaultValue = "") String transactionType,
			Model model, HttpSession session) {
		System.out.println("@GetMapping(\"/transaction\")");
		Boolean auth = (Boolean) session.getAttribute("true");
		User user = (User) session.getAttribute("user");

		System.out.println(transactionType);
		if (auth != null && auth && user != null) {
			System.out.println("here");
			List<Transactions> transactions;
			model.addAttribute(user);
			if (transactionType.equals("")) {
				transactions = transactionRepository.findByUserId(user.getId());
				System.out.println("in default section");
				model.addAttribute("transactions", transactions);
			} else {
				System.out.println("in specific section");
				transactions = transactionRepository.findByTransactionTypeAndUserId(transactionType, user.getId());
				model.addAttribute("transactions", transactions);
			}
			session.setAttribute("trueMsg", true);
			return "transaction";
		}
		return "redirect:/login";
	}

}
