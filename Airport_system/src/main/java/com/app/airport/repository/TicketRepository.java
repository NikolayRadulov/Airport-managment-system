package com.app.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.airport.model.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {


}
