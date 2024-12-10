package org.example.Repositories;

import org.example.Models.Gate;
import org.example.Models.Spot;
import org.example.Models.Ticket;
import org.example.Models.Vehicle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TicketRepoImpl implements TicketRepository{

    Map<Integer,Ticket>map;
    public TicketRepoImpl() {
        map = new TreeMap<>();
    }
    @Override
    public Ticket insertTicket(Gate gate, Date entryTime, Spot assignedSpot, Vehicle vehicle) {
        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setEntrytime(entryTime);
        ticket.setVehicle(vehicle);
        ticket.setAssignedSpot(assignedSpot);
        ticket.setId(map.size()+1);
        map.put(ticket.getId(), ticket);
        return ticket;


    }
}
