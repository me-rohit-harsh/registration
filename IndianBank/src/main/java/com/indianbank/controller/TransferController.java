package com.indianbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indianbank.entity.User;
import com.indianbank.repository.UserRepository;
import com.indianbank.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TransferController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/transfer")
	public String transacion(HttpSession session) {
		System.out.println("@GetMapping(\"/transfer\")");
		User user = (User) session.getAttribute("user");

//		here what i am doing is that first checking that user is logged in or not
//		then checking that it passes the authentication part
//		It will prevent us from direct illegal access of the end points
		if ((Boolean) session.getAttribute("transferMsg")) {

			return "transfer";
		}
		return "redirect:/login";

	}

	@PostMapping("/transfer")
	public String auth(@ModelAttribute("user") User user, HttpSession session, Model model) {

		System.out.println("@PostMapping(\"/transfer\")");
		User newUser = (User) session.getAttribute("user");
		if (newUser.getPassword().equals(user.getPassword())) {
			session.setAttribute("transferMsg", true);
			model.addAttribute("user", newUser);
			return "transfer";
		}
		session.setAttribute("denied", "Oops!! You have entred incorrect password");
		session.setAttribute("msg", false);
		return "redirect:/index?denied";
	}

	@PostMapping("/findUserbyId")
	public String findUserById(@RequestParam("userId") Long userId, Model model, HttpSession session) {
		System.out.println("@PostMapping(\"/findUserbyId\")");

		User benificiaryUser = userRepository.findById(userId).orElse(null);

		if (benificiaryUser != null) {
			session.setAttribute("benificiaryUser", benificiaryUser);
			model.addAttribute("beneficiaryName", benificiaryUser.getFname() + " " + benificiaryUser.getLname());
			model.addAttribute("benificiaryId", userId);
			session.setAttribute("msg", false);
			return "transfer";
		} else {
			session.setAttribute("msg", false);
			session.setAttribute("notFoundMsg", "Oops!! User not found");
			return "redirect:/index?notFound";
		}
	}

	@PostMapping("sender")
	public String sender(@RequestParam("balance") double balance, HttpSession session) {
		System.out.println("@PostMapping(\"sender\")");
		User user = (User) session.getAttribute("user");
		if (user.getBalance() > balance) {
			user.setBalance(user.getBalance() - balance);
			userService.saveUser(user);
			User benificiaryUser = (User) session.getAttribute("benificiaryUser");
			System.out.println(benificiaryUser);
			benificiaryUser.setBalance(benificiaryUser.getBalance() + balance);
			System.out.println(benificiaryUser.getBalance());
			userService.saveUser(user);
			session.setAttribute("updatedBal", "Updated balance is " + user.getBalance());
			userService.saveUser(benificiaryUser);
			session.setAttribute("msg", true);
			session.setAttribute("sentMsg", "Transaction Successful!!");
			return "redirect:index?sent";
		} else {
			session.setAttribute("msg", false);
			session.setAttribute("errorMsg", "Transaction declinded Due to Insufficient Funds!!");
			return "redirect:index?transactionError";
		}
	}
//	@PostMapping("/findUserbyId")
//	public String findUserbyId(@RequestParam("userId") Long userId, HttpSession session) {
//		System.out.println(userId);
//		User user = userService.getUser(userId).orElse(null);
//		if (user != null) {
//			session.setAttribute("transferMsg", true);
//			session.setAttribute("userName", user.getFname()+" "+user.getLname());
//			session.setAttribute("msg", false);
//			return "redirect:/transfer";
//		}
//		session.setAttribute("notFound", "Oops!! No user found!!");
//		session.setAttribute("msg", false);
//		return "redirect:/index?notFound";
//	}
}

/*
 * When user click on the send money button then pop up a authentication form 👍
 * done after successful authentication redirect user into transfer page where
 * 👍 user done will enter the USER Id then in the right side of the input
 * filed👍 there will be a submit button named verify, when that user will click
 * in the👍 verify then the user id will come to the controller and will be
 * checked for👍 its existence and if false then will redirect to the transfer
 * page with alert👍 otherwise the name of that entered user id will be printed
 * and then there 👍 will be two method fast and fast cash. and one input amount
 * field. will check👍 for sufficient fund then only the operation will be
 * allowed otherwise alert with insufficient funds if successfully sent then
 * redirect to the index page with a alert sent with updated balance.
 */