package com.example.TicketAPI.model;

import java.util.UUID;

public class Ticket {
    private final UUID id;
    private final String title;

    public Ticket(UUID id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
