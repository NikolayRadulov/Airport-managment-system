package com.app.airport.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.airport.model.dto.UserLoginDto;
import com.app.airport.model.dto.UserRegisterDto;
import com.app.airport.service.TicketService;
import com.app.airport.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	private final UserService userService;
	
	public UserController(TicketService ticketService, UserService userService) {
		this.userService = userService;
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
	public String getLoginPage(Model model) {
		return "login.html";
	}
	
	@GetMapping("/register")
	public String getRegisterPage(Model model, HttpSession httpSession) {
		if(!model.containsAttribute("userRegisterDto")) {
			model.addAttribute("userRegisterDto", new UserRegisterDto());
		}
	
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
	public String goHome(Model model, @Valid @ModelAttribute("userRegisterDto") UserRegisterDto userRegisterDto, BindingResult bindingResult, HttpSession httpSession, HttpServletResponse httpServletResponse) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("userRegisterDto", userRegisterDto);			
			return "register";
		}
		
		if(userRegisterDto.isToRemember()) {
			addCookie(httpServletResponse, "username", userRegisterDto.getUsername());
		}
		
		httpSession.setAttribute("username", userRegisterDto.getUsername());
		
		userService.registerUser(userRegisterDto);
		
		return "redirect:/";
	}
	
	@PostMapping("/loggedIn")
	public String goHomeLoggedIn(RedirectAttributes redirectAttributes, UserLoginDto userLoginDto, HttpSession httpSession, HttpServletResponse httpServletResponse) {
		try {
			userService.loginUser(userLoginDto);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("isInvalid", true);
			return "redirect:/login";
		}
		
		httpSession.setAttribute("username", userLoginDto.getUsername());
		
		if(userLoginDto.isToRemember()) {
			addCookie(httpServletResponse, "username", userLoginDto.getUsername());
		}
		
		return "redirect:/";
	}
	
	private void addCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setHttpOnly(true);
		cookie.setMaxAge(600);
		response.addCookie(cookie);
	}
}
