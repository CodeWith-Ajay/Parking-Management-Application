package org.example.Services;

import org.example.Models.Ticket;
import org.example.Models.VehicleType;

public interface TicketService {
    public Ticket createTicket(String regNo, int gateId, VehicleType vehicleType);
}
