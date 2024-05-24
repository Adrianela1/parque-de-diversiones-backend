package com.msvc.tickets.repositories;

import com.msvc.tickets.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Tickets, Integer> {

}
