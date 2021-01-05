package com.example.TicketAPI.dao;

import com.example.TicketAPI.model.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TicketDao {

    int insertTicket(UUID id, Ticket ticket);

    default int insertTicket(Ticket ticket){
        UUID id = UUID.randomUUID();
        return insertTicket(id, ticket);
    }

    List<Ticket> selectAllTickets();

    Optional<Ticket> selectTicketById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Ticket ticket);
}
