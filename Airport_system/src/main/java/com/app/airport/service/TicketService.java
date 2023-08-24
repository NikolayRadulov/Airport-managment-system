package com.app.airport.service;

import java.util.List;

import com.app.airport.model.entity.Ticket;

public interface TicketService {
	
	List<Ticket> searchForTickets();
	
	void addTicket(Ticket ticket);
}
