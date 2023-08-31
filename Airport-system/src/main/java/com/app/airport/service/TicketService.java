package com.app.airport.service;

import java.util.List;

import com.app.airport.model.dto.TicketDto;
import com.app.airport.model.dto.TicketSearchDto;
import com.app.airport.model.entity.Ticket;

public interface TicketService {
	
	List<Ticket> searchForTickets(TicketSearchDto ticketSearchDto);
	
	void addTicket(TicketDto ticket);
}
