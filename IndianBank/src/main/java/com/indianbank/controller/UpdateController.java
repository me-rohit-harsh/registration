package com.indianbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.indianbank.entity.ChangePass;
import com.indianbank.entity.User;
import com.indianbank.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UpdateController {

	@Autowired
	private UserService userService;

	@GetMapping("/update")
	public String updateProfile(HttpSession session, Model model) {
		System.out.println("@GetMapping(\"/update\")");
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		return "update";
	}

	@PostMapping("/deleteuser")
	public String deleteuser(HttpSession session) {
		System.out.println("@PostMapping(\"/deleteuser\")");
		User user = (User) session.getAttribute("user");
		boolean deleteUser = userService.deleteUser(user.getId());
		if (deleteUser) {
			session.setAttribute("true", true);
			return "redirect:/?success";
		}
		session.setAttribute("true", false);
		return "redirect:/?error";
	}

	@PostMapping("/changePassword")
	public String changePassword(@ModelAttribute("ChangePass") ChangePass changePass, HttpSession session) {

		System.out.println("@PostMapping(\"/changePassword\")");
		User user = (User) session.getAttribute("user");

		if (user.getPassword().equals(changePass.getOldPassword())
				&& changePass.getNewPassword().equals(changePass.getNewPassword1())) {
			System.out.println("Updated succefully");
			user.setPassword(changePass.getNewPassword());
//			I need to implement a new method to update the new password of the corresponding user done 
			userService.saveUser(user);
			session.setAttribute("message1", "Your password has been changed");
			session.setAttribute("msg1", true);
			return "redirect:/index?changed";
		}
		session.setAttribute("msg", false);
		session.setAttribute("errormsg", "Oops!! Something went wrong!");
		return "redirect:/index?error";
	}

	@PostMapping("/personalDetails")
	public String personalDetails(@ModelAttribute("user") User user, HttpSession session) {

		System.out.println("@PostMapping(\"/personalDetails\")");
		if (user != null) {
			User oldUser = (User) session.getAttribute("user");
			oldUser.setFname(user.getFname());
			oldUser.setLname(user.getLname());
			oldUser.setSex(user.getSex());
			oldUser.setAddress(user.getAddress());
			oldUser.setdOB(user.getdOB());
			oldUser.setEmail(user.getEmail());
			userService.saveUser(oldUser);
			session.setAttribute("message", "Your personal information has been updated");
			session.setAttribute("msg", true);
			return "redirect:/index?success";
		}
		session.setAttribute("msg", false);
		session.setAttribute("errormsg", "Oops!! Something went wrong!");
		return "redirect:/index?error";
	}

	@PostMapping("/deposit")
	public String deposit(@ModelAttribute("user") User user, HttpSession session) {
		if (user.getBalance() != 0) {
			User getUser = (User) session.getAttribute("user");
			getUser.setBalance(getUser.getBalance() + user.getBalance());
			session.setAttribute("newBalance", getUser.getBalance());
			userService.saveUser(getUser);
			session.setAttribute("deposit", true);
			session.setAttribute("depoMessage", "Money has been credited!!  ");
			return "redirect:index?deposited";
		}
		session.setAttribute("msg", false);
		session.setAttribute("errormsg", "Oops!! Something went wrong!");
		return "redirect:index?error";
	}

	@PostMapping("/withdrawl")
	public String withdrawl(@ModelAttribute("user") User user, HttpSession session) {
		User getUser = (User) session.getAttribute("user");
		if (getUser.getPassword().equals(user.getPassword())) {
			if (getUser.getBalance() > user.getBalance()) {
				getUser.setBalance(getUser.getBalance() - user.getBalance());
				session.setAttribute("newBalance", getUser.getBalance());
				userService.saveUser(getUser);
				session.setAttribute("withdraw", true);
				session.setAttribute("withdrawMessage", "Money has been debited!!  ");
				return "redirect:/index?withdrawn";
			}
			session.setAttribute("msg", false);
			session.setAttribute("errormsg", "Opps! Insufficient funds");
			return "redirect:index?error";
		} else {
			session.setAttribute("msg", false);
			session.setAttribute("errormsg", "Opps! Incorrect Password");
			return "redirect:index?error";
		}

	}
//	I am able to get the authenticated user and send them back to the view
//	and now what i have to do is to create update page
//	and write back end code to save the newly data in DB
//	i have implemented deposit and withdrawal functionalities
	/*
	 * now i have to implement send money so for that i need to create a new page
	 * where i will take input of receiver userId as UPI Id. and will provide
	 * function to check whether that user exists or not if yes then will display
	 * the name of the user. and then will check that balance entered is less or
	 * equal than the total fund, and then authentication and then finally sent
	 */

}
