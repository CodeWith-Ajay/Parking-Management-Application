package org.example.Controllers;

import org.example.Dto.GenerateTicketRequestDto;
import org.example.Dto.GenerateTicketResponseDto;
import org.example.Dto.ResponseStatus;
import org.example.Exceptions.NoSpotAvailable;
import org.example.Models.Ticket;
import org.example.Services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto) {
        GenerateTicketResponseDto dto=new GenerateTicketResponseDto();

        try{
            Ticket ticket=ticketService.createTicket(generateTicketRequestDto.getRegNo(),generateTicketRequestDto.getGateId(), generateTicketRequestDto.getVehicleType());
            dto.setTicket(ticket);
            dto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(NoSpotAvailable e){
            dto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return dto;
    }
}
