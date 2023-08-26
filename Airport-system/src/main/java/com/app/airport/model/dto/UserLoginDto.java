package com.app.airport.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserLoginDto {

	@NotBlank
	@Size(min = 4, max = 25, message = "Username must be between 4 and 25 symbols long!")
	private String username;
	
	@NotBlank
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Password must contain at least 8 symbols, including a lowercase and a uppercase letter, a number and a special character!")
	private String password;
	
	@NotBlank
	@Email(message = "Invalid email")
	private String email;
	
	@NotNull
	private boolean toRemember;
	
	
	public UserLoginDto() {
		// TODO Auto-generated constructor stub
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isToRemember() {
		return toRemember;
	}


	public void setToRemember(boolean toRemember) {
		this.toRemember = toRemember;
	}

}
