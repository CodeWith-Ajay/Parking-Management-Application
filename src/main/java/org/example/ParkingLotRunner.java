package org.example;

import org.example.Controllers.TicketController;
import org.example.Dto.GenerateTicketRequestDto;
import org.example.Dto.GenerateTicketResponseDto;
import org.example.Models.*;
import org.example.Repositories.*;
import org.example.Services.*;
import org.example.Strategy.NearestSpotAvailableStategy;
import org.example.Strategy.SpotAssignStrategy;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParkingLotRunner {
    public static void main(String[] args) {
        Gate gate1 = new Gate();
        gate1.setId(1);
        gate1.setGateType(GateType.ENTRY);
        gate1.setCurrentOperator(new Operator());

        Map<Integer,Gate> gateMap=new TreeMap<>();
        gateMap.put(1,gate1);
        // Map<Integer,Gate> map=new TreeMap<>(){{
        // put(1,gate1);
        // }}; to initialize in single line

        GateRepository gateRepository=new GateRepoImpl(gateMap);
        Floor floor=new Floor();
        floor.setGates(List.of(gate1));

        Spot spot1=new Spot();
        spot1.setId(1);
        spot1.setVehicleType(VehicleType.CAR);

        Spot spot2=new Spot();
        spot2.setId(2);
        spot2.setVehicleType(VehicleType.BIKE);

        floor.setSpots(List.of(spot1,spot2));
        floor.setFloorstatus(FloorStatus.OPEARTIONAL);
        floor.setId(1);


        ParkingLot parkinglot=new ParkingLot();
        parkinglot.setAddress("ISKCON NVCC, PUNE");
        VehicleRepository vehicleRepository=new VehicleRepoImpl();
        parkinglot.setFloors(List.of(floor));
        parkinglot.setId(1);

        Map<Integer,ParkingLot>parkingLotMap=new TreeMap<>(){{
            put(parkinglot.getId(), parkinglot);
        }};

        ParkingRepository parkingRepository=new ParkingLotRepoImpl(parkingLotMap);

        ParkingLotService parkingLotService=new ParkingServiceImpl(parkingRepository);
        VehicleService vehicleService = new VehicleServiceImpl(vehicleRepository);
        GateService gateService=new GateServiceImpl(gateRepository);

        TicketRepository ticketRepository=new TicketRepoImpl();
        SpotAssignStrategy spotAssignStrategy =new NearestSpotAvailableStategy();
        TicketService ticketService=new TicketServiceImpl(vehicleService,parkingLotService,gateService, ticketRepository,spotAssignStrategy);
        TicketController ticketController=new TicketController(ticketService);

        GenerateTicketRequestDto dto=new GenerateTicketRequestDto();
        dto.setVehicleType(VehicleType.CAR);
        dto.setGateId(gate1.getId());
        dto.setRegNo("MH 24 2244");
        GenerateTicketResponseDto generateTicketResponseDto = ticketController.generateTicket(dto);
        System.out.println("Gate No.- "+dto.getGateId()+" RegNo.- " +dto.getRegNo()+" VehicaleType- "+dto.getVehicleType());
    }
}
