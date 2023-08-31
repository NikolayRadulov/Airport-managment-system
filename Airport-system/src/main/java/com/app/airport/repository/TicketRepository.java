package com.app.airport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.airport.model.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query("SELECT t from Ticket t WHERE t.sourceCountry = ?1 and t.destinationCountry = ?2 and t.price >= ?3 and t.price <= ?4")
	List<Ticket> findFilteredTickets(String sourceCounry, String destinationCountry, double minPrice, double maxPrice);
}
