package com.app.airport.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	public MainController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/")
	public String getHomePage() {
		return "index.html";
	}


}
