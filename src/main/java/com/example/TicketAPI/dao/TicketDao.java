package com.example.TicketAPI.dao;

import com.example.TicketAPI.model.Ticket;

import java.util.UUID;

public interface TicketDao {

    int insertTicket(UUID id, Ticket ticket);

    default int insertTicket(Ticket ticket){
        UUID id = UUID.randomUUID();
        return insertTicket(id, ticket);
    }
}
