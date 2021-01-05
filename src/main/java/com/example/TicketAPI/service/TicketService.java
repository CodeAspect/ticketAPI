package com.example.TicketAPI.service;

import com.example.TicketAPI.dao.TicketDao;
import com.example.TicketAPI.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketDao ticketDao;

    @Autowired
    public TicketService(@Qualifier("TicketDao") TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    public int addTicket(Ticket ticket) {
        return ticketDao.insertTicket(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketDao.selectAllTickets();
    }

    public Optional<Ticket> getTicketById(UUID id){
        return ticketDao.selectTicketById(id);
    }

    public int deleteTicket(UUID id) {
        return ticketDao.deletePersonById(id);
    }

    public int updateTicket(UUID id, Ticket newTicket) {
        return ticketDao.updatePersonById(id, newTicket);
    }
}
