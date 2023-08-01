package com.softdyze.Service;

import org.springframework.stereotype.Service;

import com.softdyze.binding.LoginForm;
import com.softdyze.binding.SignUpForm;

@Service
public interface UserService {
	public String login(LoginForm loginForm);

	public boolean signup(SignUpForm signupForm);

	public boolean forgotPwd(String email);

}
