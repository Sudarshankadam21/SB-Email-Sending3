package com.emailexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emailexample.model.Email;
import com.emailexample.service.Emailservice;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
      @Autowired 
	private Emailservice emailservice;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute Email email,HttpSession session) {
		
		emailservice.sendMail(email);
		
		session.setAttribute("msg", "Email send sucessfully");
		
		return "redirect:/";
	}
	
}
