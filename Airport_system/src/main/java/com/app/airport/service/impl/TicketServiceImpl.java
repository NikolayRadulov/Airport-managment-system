package com.app.airport.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.airport.model.entity.Ticket;
import com.app.airport.repository.TicketRepository;
import com.app.airport.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	private final TicketRepository ticketRepository;
	private final ModelMapper modelMapper;
	
	public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper) {
		this.ticketRepository = ticketRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<Ticket> searchForTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub

	}

}
