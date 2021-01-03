package com.example.TicketAPI.dao;

import com.example.TicketAPI.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("TicketDao")
public class TicketDataAccessService implements TicketDao {

    private static List<Ticket> ticketDB = new ArrayList<>();
    @Override
    public int insertTicket(UUID id, Ticket ticket) {
        ticketDB.add(new Ticket(id, ticket.getTitle()));
        return 1;
    }
}
