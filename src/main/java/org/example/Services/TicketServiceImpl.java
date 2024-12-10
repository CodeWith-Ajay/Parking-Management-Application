package org.example.Services;

import org.example.Exceptions.NoSpotAvailable;
import org.example.Models.*;
import org.example.Repositories.GateRepository;
import org.example.Repositories.TicketRepoImpl;
import org.example.Repositories.TicketRepository;
import org.example.Strategy.SpotAssignStrategy;

import java.util.Date;

public class TicketServiceImpl implements TicketService {
    VehicleService vehicleService;
    ParkingLotService parkingLotService;
    SpotAssignStrategy spotAssignStrategy;
    TicketRepository ticketRepository;
    GateService gateService;

   public TicketServiceImpl(VehicleService vehicleService, ParkingLotService parkingLotService,GateService gateService,TicketRepository ticketRepository,SpotAssignStrategy spotAssignStrategy) {
       this.vehicleService = vehicleService;
       this.parkingLotService = parkingLotService;
       this.gateService = gateService;
       this.ticketRepository = ticketRepository;
       this.spotAssignStrategy = spotAssignStrategy;
   }

    @Override
    public Ticket createTicket(String regNo, int gateId, VehicleType vehicleType) throws NoSpotAvailable {
        Vehicle vehicle = vehicleService.createOrget(regNo, vehicleType);
        ParkingLot parkingLot=parkingLotService.getParkingLotByGateId(gateId);
        Spot spot = spotAssignStrategy.findAvailableSpot(parkingLot.getFloors(),vehicleType);
        spot.setVehicle(vehicle);
        Gate gate=this.gateService.getGate(gateId);
        Ticket ticket=ticketRepository.insertTicket(gate,new Date(),spot,vehicle);

        return ticket;
    }
}
