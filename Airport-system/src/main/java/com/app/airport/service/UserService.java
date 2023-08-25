package com.app.airport.service;

import com.app.airport.model.dto.UserRegisterDto;
import com.app.airport.model.entity.User;

public interface UserService {

	void loginUser(User user);
	void registerUser(UserRegisterDto user);
	void logoutUser(User user);

}
