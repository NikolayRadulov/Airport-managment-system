package com.app.airport.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.airport.model.dto.UserLoginDto;
import com.app.airport.model.dto.UserRegisterDto;
import com.app.airport.service.TicketService;
import com.app.airport.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	private final UserService userService;
	private final TicketService ticketService;
	
	public MainController(TicketService ticketService, UserService userService) {
		this.userService = userService;
		this.ticketService = ticketService;
	}
	
	
	@GetMapping("/")
	public String getHomePage(Model model, HttpSession httpSession, @CookieValue(name = "username", required = false) String cookieUsername) {
		if(cookieUsername != null) httpSession.setAttribute("username", cookieUsername);
		
		Object username = httpSession.getAttribute("username");
		if(username != null) {
			model.addAttribute("isUserLoggedIn", userService.findUser(username.toString()).isLoggedIn());
		}
		
		return "index.html";
	}

	@GetMapping("/login") 
	public String getLoginPage() {
		return "login.html";
	}
	
	@GetMapping("/register")
	public String getRegisterPage(HttpSession httpSession) {
		
		return "register.html";
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession httpSession) {
		Object username = httpSession.getAttribute("username");
		if(username != null) {
			userService.logoutUser(userService.findUser(username.toString()));
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/registered")
	public String goHome(Model model, UserRegisterDto userRegisterDto, HttpSession httpSession, HttpServletResponse httpServletResponse) {
		
		if(userRegisterDto.isToRemember()) {
			addCookie(httpServletResponse, "username", userRegisterDto.getUsername());
		}
		httpSession.setAttribute("username", userRegisterDto.getUsername());
		
		userService.registerUser(userRegisterDto);
		
		return "redirect:/";
	}
	
	@PostMapping("/loggedIn")
	public String goHomeLoggedIn(Model model, UserLoginDto userLoginDto, HttpSession httpSession, HttpServletResponse httpServletResponse) {
		userService.loginUser(userLoginDto);
		httpSession.setAttribute("username", userLoginDto.getUsername());
		
		if(userLoginDto.isToRemember()) {
			addCookie(httpServletResponse, "username", userLoginDto.getUsername());
		}
		
		return "redirect:/";
	}
	
	private void addCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setHttpOnly(true);
		cookie.setMaxAge(300);
		response.addCookie(cookie);
	}
}
