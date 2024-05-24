package com.msvc.tickets.controller;

import com.msvc.tickets.dto.CantidadEntradasVendidasJuegoDto;
import com.msvc.tickets.models.Tickets;
import com.msvc.tickets.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/tickets")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Tickets> getAllTickets() {
        return ticketsService.findAllTickets();
    }

    @GetMapping("{id}")
    public ResponseEntity<Tickets> getTicketsById(@PathVariable Long id){
        return ticketsService.findTicketsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/gameAndtickets/{date}")
    public ResponseEntity<List<CantidadEntradasVendidasJuegoDto>> getTicketsAndGameByDate(@PathVariable String date){
        List<CantidadEntradasVendidasJuegoDto> ticektsAndGames = ticketsService.findTicketsAndGameByDate(date);
        return new ResponseEntity<>(ticektsAndGames, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Tickets createTickets(@RequestBody Tickets tickets){
        return ticketsService.saveTickets(tickets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tickets> updateTickets(@PathVariable Long id, @RequestBody Tickets ticketsDetails) {
        Tickets updatedTickets = ticketsService.updateTickets(id, ticketsDetails);
        if (updatedTickets != null) {
            return new ResponseEntity<>(updatedTickets, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTickets(@PathVariable Long id) {
        ticketsService.deleteTickets(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
