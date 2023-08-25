package com.app.airport.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.airport.model.dto.UserRegisterDto;
import com.app.airport.service.TicketService;
import com.app.airport.service.UserService;

import ch.qos.logback.core.model.Model;

@Controller
public class MainController {

	private final UserService userService;
	private final TicketService ticketService;
	
	public MainController(TicketService ticketService, UserService userService) {
		this.userService = userService;
		this.ticketService = ticketService;
	}
	
	
	@GetMapping("/")
	public String getHomePage() {
		return "index.html";
	}

	@GetMapping("/login") 
	public String getLoginPage() {
		return "login.html";
	}
	
	@GetMapping("/register")
	public String getRegisterPage() {
		return "register.html";
	}
	
	@PostMapping("/registered")
	public String goHome(Model model, UserRegisterDto userRegisterDto) {
		userService.registerUser(userRegisterDto);
		
		return "redirect:/";
	}

}
