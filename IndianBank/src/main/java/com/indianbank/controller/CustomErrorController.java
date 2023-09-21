package com.indianbank.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CustomErrorController {

    @GetMapping("/error")
    public String handleNotFound() {
        // You can add custom logic here if needed
        return "redirect:/login";
    }
}
