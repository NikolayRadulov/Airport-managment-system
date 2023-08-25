package com.app.airport.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.airport.model.dto.UserRegisterDto;
import com.app.airport.model.entity.User;
import com.app.airport.repository.UserRepository;
import com.app.airport.service.UserService;
import com.app.airport.util.ValidationUtil;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	private final ValidationUtil validationUtil;
	
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.validationUtil = validationUtil;
	}

	@Override
	public void loginUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerUser(UserRegisterDto userDto) {
		if(!userDto.getPassword().equals(userDto.getConfirmPassword())) {
			throw new IllegalArgumentException("Passwords must match!");
		}
		if(!validationUtil.isValid(userDto) || userDto.getUsername().equals("admin")) throw new IllegalArgumentException();
		
		User user = modelMapper.map(userDto, User.class);
		
		userRepository.save(user);
		System.out.println("User successfully registered");
	}

	@Override
	public void logoutUser(User user) {
		// TODO Auto-generated method stub

	}

}
