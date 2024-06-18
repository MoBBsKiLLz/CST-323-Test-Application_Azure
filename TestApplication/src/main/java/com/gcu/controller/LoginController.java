package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/")
public class LoginController {
	@GetMapping("/login")
	public String display(Model model) {
		// Display Login Form View
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(LoginModel loginModel, BindingResult bindingResult, Model model) {
		// Print the form values out
		System.out.println(String.format("Forms with Username of %s and Password %s", loginModel.getUsername(), loginModel.getPassword()));
		
		// Navigate back to the Login View
		return "redirect:/product/list";
	}

}
