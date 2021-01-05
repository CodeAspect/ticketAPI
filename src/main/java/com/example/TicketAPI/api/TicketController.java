package com.example.TicketAPI.api;

import com.example.TicketAPI.model.Ticket;
import com.example.TicketAPI.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/ticket")
@RestController
public class TicketController {

    final private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public void addTicket(@RequestBody Ticket ticket)
    {
        ticketService.addTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getAllPeople() {
        return ticketService.getAllTickets();
    }

    @GetMapping(path = "{id}")
    public Ticket getTicketById(@PathVariable("id") UUID id) {
        return ticketService.getTicketById(id)
                .orElse( null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTicketById(@PathVariable("id") UUID id) {
        ticketService.deleteTicket(id);
    }

    @PutMapping(path = "{id}")
    public void updateTicket(@PathVariable("id") UUID id, @RequestBody Ticket ticketToUpdate) {
        ticketService.updateTicket(id, ticketToUpdate);
    }

}
