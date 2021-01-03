package com.example.TicketAPI.service;

import com.example.TicketAPI.dao.TicketDao;
import com.example.TicketAPI.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
