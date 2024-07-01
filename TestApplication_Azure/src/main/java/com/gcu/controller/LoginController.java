package com.gcu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;

@Controller
public class LoginController {
	// SLF4J Logger
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
	@GetMapping(value={"/", "/login"})
	public String display(Model model) {
		// Display Login Form View
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(LoginModel loginModel, BindingResult bindingResult, Model model) {
		// Log the form values 
		logger.info("Forms with Username of '" + loginModel.getUsername() + "' and Password '" + loginModel.getPassword() + "'.");
		
		// Navigate back to the Login View
		return "redirect:/product/list";
	}

}
