package org.example.Dto;

import org.example.Models.Ticket;

public class GenerateTicketResponseDto {
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    private Ticket ticket;
    private ResponseStatus responseStatus;
}
