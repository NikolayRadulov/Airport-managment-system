package com.app.airport.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.airport.model.entity.User;
import com.app.airport.repository.UserRepository;
import com.app.airport.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void loginUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logoutUser(User user) {
		// TODO Auto-generated method stub

	}

}
