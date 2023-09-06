package com.app.airport.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.airport.model.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query("SELECT t from Ticket t WHERE t.sourceCountry = ?1 and t.destinationCountry = ?2 and t.price >= ?3 and t.price <= ?4")
	List<Ticket> findFilteredTickets(String sourceCounry, String destinationCountry, double minPrice, double maxPrice);
	
	@Query("Select t from Ticket t Where year(?1) = year(t.arrivalTime) and month(?1) = month(t.arrivalTime) and day(?1) = day(t.arrivalTime)")
	List<Ticket> findByArrivalTime(LocalDate time);
	
	@Query("Select t from Ticket t Where year(?1) = year(t.departmentTime) and month(?1) = month(t.departmentTime) and day(?1) = day(t.departmentTime)")
	List<Ticket> findByDepartmentTime(LocalDate time);
}
