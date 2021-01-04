package com.example.TicketAPI.api;

import com.example.TicketAPI.model.Ticket;
import com.example.TicketAPI.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
