package com.example.TicketAPI.dao;

import com.example.TicketAPI.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("TicketDao")
public class TicketDataAccessService implements TicketDao {

    private static List<Ticket> ticketDB = new ArrayList<>();

    @Override
    public int insertTicket(UUID id, Ticket ticket) {
        ticketDB.add(new Ticket(id, ticket.getTitle()));
        return 1;
    }

    @Override
    public List<Ticket> selectAllTickets() {
        return ticketDB;
    }

    @Override
    public Optional<Ticket> selectTicketById(UUID id) {
        return ticketDB.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Ticket> ticketMaybe = selectTicketById(id);
        if(ticketMaybe.isEmpty())
        {
            return 0;
        }
        ticketDB.remove(ticketMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Ticket ticket) {
        return selectTicketById(id)
                .map(p -> {
                    int indexOfTicketToDelete = ticketDB.indexOf(ticket);
                    if (indexOfTicketToDelete >= 0) {
                        ticketDB.set(indexOfTicketToDelete, ticket);
                    return 1;
                    }
                    return 0;
                })
                .orElse( 0);
    }
}
