package com.indianbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        // Invalidate the user's session
	        session.invalidate();
	        return "redirect:/login"; // Redirect to the login page after logout
	    }
}
