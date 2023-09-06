package com.indianbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.indianbank.entity.User;
import com.indianbank.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/users")
	public String allUsers(Model model) {
		System.out.println("@GetMapping(\"/users\")");
		model.addAttribute("users", userService.allUser());
		return "users";
	}

	@GetMapping("register")
	public String createUserForm(Model model) {
		System.out.println("@GetMapping(\"register\")");
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}

	@PostMapping("/user")
	public String saveUser(@ModelAttribute("user") User user, HttpSession session) {
		Long userId = userService.saveUserId(user);
		session.setAttribute("userId", userId);
		return "redirect:/register?success";
	}

//In This using HttpSession to pass the attribute not Model because of its scope

	@GetMapping("/index")
	public String dashboard(Model model) {
		System.out.println("@GetMapping(\"/index\")");
		model.addAttribute("users", userService.allUser());
		return "index";
	}

}
