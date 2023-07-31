package com.softdyze.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SignUpForm {
	
	
	private String fullName;
	private String email;
	private String pwd;
	private Long mobileNo;
	private String gender;
	private LocalDate dob;

}
