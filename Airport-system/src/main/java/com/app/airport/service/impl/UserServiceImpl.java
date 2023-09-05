package com.app.airport.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.airport.model.dto.UserLoginDto;
import com.app.airport.model.dto.UserRegisterDto;
import com.app.airport.model.entity.Ticket;
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
	public void loginUser(UserLoginDto userDto) {
		User user = userRepository.findByUsername(userDto.getUsername());
		if(user == null || !user.getPassword().equals(userDto.getPassword()) || !user.getEmail().equals(userDto.getEmail())) {
			throw new IllegalArgumentException("Invalid credentials");
		}
		
		user.setLoggedIn(true);
		userRepository.save(user);
	}

	@Override
	public void registerUser(UserRegisterDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		user.setLoggedIn(true);
		userRepository.save(user);
	}

	@Override
	public void logoutUser(User user) {
		user.setLoggedIn(false);
		userRepository.save(user);
	}

	@Override
	public User findUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void saveTicket(String username, Ticket ticket) {
		User user = userRepository.findByUsername(username);
		user.getTickets().add(ticket);
		userRepository.save(user);
	}

}
