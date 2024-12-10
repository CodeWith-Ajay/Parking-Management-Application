package org.example.Repositories;

import org.example.Models.Gate;
import org.example.Models.Spot;
import org.example.Models.Ticket;
import org.example.Models.Vehicle;

import java.util.Date;

public interface TicketRepository {

    public Ticket insertTicket(Gate gate, Date entryTime, Spot assignedSpot, Vehicle vehicle);
}