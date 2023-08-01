package com.softdyze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.softdyze.Service.UserService;
import com.softdyze.binding.LoginForm;
import com.softdyze.binding.SignUpForm;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/signup")
	public String signUpPage(Model model) {
		model.addAttribute("user", new SignUpForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String handleSignUp(@ModelAttribute("user") SignUpForm form, Model model) {
		boolean status = userService.signup(form);
		if (status) {
			model.addAttribute("succMsg", "Account  Created !!!");
		} else {
			model.addAttribute("errMsg", "Choose Unique Email");
		}
		return "signup";
	}

	@GetMapping("/login")
	public String loginUserPage(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		// System.out.println(loginForm);
		String status = userService.login(loginForm);
		if (status.contains("success")) {

			return "redirect:/dashboard";
		}
		model.addAttribute("errMsg", status);
		return "login";
	}
}
