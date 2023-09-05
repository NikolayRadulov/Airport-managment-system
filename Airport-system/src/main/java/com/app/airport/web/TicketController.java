package com.app.airport.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.airport.model.dto.TicketSearchDto;
import com.app.airport.model.entity.Ticket;
import com.app.airport.service.TicketService;
import com.app.airport.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class TicketController {

	private final TicketService ticketService;
	private final UserService userService;
	
	public TicketController(TicketService ticketService, UserService userService) {
		this.ticketService = ticketService;
		this.userService = userService;
	}
	
	@GetMapping("/addTicket")
	public String addTicket(Model model, HttpSession session) {
		if(session.getAttribute("username") == null) return "redirect:/";
		model.addAttribute("id", 1);
		
		return "addTicket.html";
	}
	
	@PostMapping("/addTicket")
	public String addTicket(Model model, TicketSearchDto ticketSearchDto, HttpSession session) {
		if(session.getAttribute("username") == null) return "redirect:/";
				
		List<Ticket> tickets = ticketService.searchForTickets(ticketSearchDto);
		session.setAttribute("userTicketList", tickets);
		model.addAttribute("tickets", tickets);
		
		return "addTicket.html";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/saveTicket/{id}")
	public String saveAndRedirect(@PathVariable("id")int id, HttpSession session) {
		if(session.getAttribute("username") == null) return "redirect:/";
		userService.saveTicket((String)session.getAttribute("username"), ((List<Ticket>)session.getAttribute("userTicketList")).get(id-1));
		return "redirect:/";
	}
	
	@GetMapping("/seeSavedTickets")
	public String seeSavedTickets(Model model, HttpSession session) {
		if(session.getAttribute("username") == null) return "redirect:/";
		
		model.addAttribute("tickets", userService.findUser((String)session.getAttribute("username")).getTickets());
		
		return "savedTickets.html";
	}
	
	@GetMapping("/seeAllTickets")
	public String seeAllTickets(Model model, HttpSession session) {
		if(session.getAttribute("username") == null) return "redirect:/";
		
		model.addAttribute("tickets", ticketService.getAllTickets());
		
		return "allTickets.html";
	}
	

}
