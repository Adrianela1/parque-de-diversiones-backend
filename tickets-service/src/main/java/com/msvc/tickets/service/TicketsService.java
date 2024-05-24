package com.msvc.tickets.service;

import com.msvc.tickets.models.Tickets;
import com.msvc.tickets.repositories.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TicketsService {
    @Autowired
    private TicketsRepository ticketsRepository;

    //Get para obtener todos los tickets
    public List<Tickets> findAllTickets(){
        return ticketsRepository.findAll();
    }

    //Get para obtener los tickets por id
    public Optional<Tickets> findTicketsById (Integer id){
        return ticketsRepository.findById(id);
    }

    //Post
    public Tickets saveTickets(Tickets tickets) {
        return ticketsRepository.save(tickets);
    }
    //put
    public Tickets updateTickets (Integer id, Tickets ticketsDetails){
        Optional <Tickets> optionalTickets = ticketsRepository.findById(id);

        if (optionalTickets.isPresent()) {
            Tickets existingTickets = optionalTickets.get();
            existingTickets.setDate(ticketsDetails.getDate());
            existingTickets.setHour(ticketsDetails.getHour());
            existingTickets.setId_game(ticketsDetails.getId_game());
            existingTickets.setId_buyer(ticketsDetails.getId_buyer());
            return ticketsRepository.save(existingTickets);
        } else {
            return null;
        }
    }

    //Delete
    public void deleteTickets(Integer id) {
        ticketsRepository.deleteById(id);
    }
}
