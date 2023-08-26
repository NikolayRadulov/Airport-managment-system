package com.app.airport.service;

import com.app.airport.model.dto.UserLoginDto;
import com.app.airport.model.dto.UserRegisterDto;
import com.app.airport.model.entity.User;

public interface UserService {

	User findUser(String username);
	void loginUser(UserLoginDto user);
	void registerUser(UserRegisterDto user);
	void logoutUser(User user);

}
