package com.app.airport.service;

import com.app.airport.model.entity.User;

public interface UserService {

	void loginUser(User user);
	void registerUser(User user);
	void logoutUser(User user);

}
