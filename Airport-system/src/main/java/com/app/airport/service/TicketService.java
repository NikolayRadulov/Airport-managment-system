package com.app.airport.service;

import java.time.LocalDate;
import java.util.List;

import com.app.airport.model.dto.TicketDto;
import com.app.airport.model.dto.TicketSearchDto;
import com.app.airport.model.entity.Ticket;

public interface TicketService {
	
	List<Ticket> searchForTickets(TicketSearchDto ticketSearchDto);
	
	void addTicket(TicketDto ticket);
	
	List<Ticket> getAllTickets();
	
	List<Ticket> getTicketsByArrivalDate(LocalDate arrival);
	
	List<Ticket> getTicketsByDepartmentDate(LocalDate department);

}
