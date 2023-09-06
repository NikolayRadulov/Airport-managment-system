package com.app.airport.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.airport.model.dto.TicketDto;
import com.app.airport.model.dto.TicketSearchDto;
import com.app.airport.model.entity.Ticket;
import com.app.airport.repository.TicketRepository;
import com.app.airport.service.TicketService;
import com.app.airport.util.ValidationUtil;

@Service
public class TicketServiceImpl implements TicketService {

	private final TicketRepository ticketRepository;
	private final ModelMapper modelMapper;
	private final ValidationUtil validationUtil;
	
	public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
		this.ticketRepository = ticketRepository;
		this.modelMapper = modelMapper;
		this.validationUtil = validationUtil;
	}

	@Override
	public List<Ticket> searchForTickets(TicketSearchDto ticketSearchDto) {
		
		return ticketRepository.findFilteredTickets(ticketSearchDto.getSourceCountry(), 
													ticketSearchDto.getDestinationCountry(), 
													ticketSearchDto.getMinPrice().doubleValue(),
													ticketSearchDto.getMaxPrice().doubleValue());
	}

	@Override
	public void addTicket(TicketDto ticketDto) {
		if(!validationUtil.isValid(ticketDto)) {
			throw new IllegalArgumentException();
		}
		Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
		ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public List<Ticket> getTicketsByArrivalDate(LocalDate arrival) {
		// TODO Auto-generated method stub
		return ticketRepository.findByArrivalTime(arrival);
	}

	@Override
	public List<Ticket> getTicketsByDepartmentDate(LocalDate department) {
		// TODO Auto-generated method stub
		return ticketRepository.findByDepartmentTime(department);
	}

}
