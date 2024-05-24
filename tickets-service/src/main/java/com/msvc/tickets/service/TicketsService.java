package com.msvc.tickets.service;

import com.msvc.tickets.dto.CantidadEntradasVendidasJuegoDto;
import com.msvc.tickets.models.Tickets;
import com.msvc.tickets.repositories.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TicketsService {
    @Autowired
    private TicketsRepository ticketsRepository;

    //Get para obtener todos los tickets
    public List<Tickets> findAllTickets(){
        return ticketsRepository.findAll();
    }

    //Get para obtener los tickets por id
    public Optional<Tickets> findTicketsById (Long id){
        return ticketsRepository.findById(id);
    }

    public List<CantidadEntradasVendidasJuegoDto> findTicketsAndGameByDate(String date){
        List<Tickets> ticketsList = ticketsRepository.findTicketsByDate(date);
        return ticketsList.stream()
                .map(tickets -> CantidadEntradasVendidasJuegoDto.builder()
                        .id(tickets.getId())
                        .gameName(tickets.getGameName())
                        .date(tickets.getDate())
                        .build())
                .collect(Collectors.toList());
    }

    //Post
    public Tickets saveTickets(Tickets tickets) {
        return ticketsRepository.save(tickets);
    }
    //put
    public Tickets updateTickets (Long id, Tickets ticketsDetails){
        Optional <Tickets> optionalTickets = ticketsRepository.findById(id);

        if (optionalTickets.isPresent()) {
            Tickets existingTickets = optionalTickets.get();
            existingTickets.setDate(ticketsDetails.getDate());
            existingTickets.setHour(ticketsDetails.getHour());
            existingTickets.setGameName(ticketsDetails.getGameName());
            existingTickets.setCorreoComprador(ticketsDetails.getCorreoComprador());
            return ticketsRepository.save(existingTickets);
        } else {
            return null;
        }
    }

    //Delete
    public void deleteTickets(Long id) {
        ticketsRepository.deleteById(id);
    }
}
