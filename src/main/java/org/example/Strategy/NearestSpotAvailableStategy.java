package org.example.Strategy;

import org.example.Exceptions.NoSpotAvailable;
import org.example.Models.Floor;
import org.example.Models.FloorStatus;
import org.example.Models.Spot;
import org.example.Models.VehicleType;

import java.util.List;

public class NearestSpotAvailableStategy implements SpotAssignStrategy{
    @Override
    public Spot findAvailableSpot(List<Floor> floors, VehicleType vehicleType) throws NoSpotAvailable {
        for (Floor floor : floors) {
            if(floor.getFloorstatus()== FloorStatus.OPEARTIONAL) {
                for (Spot spot : floor.getSpots()) {
                    if (!spot.isOccupied() && spot.getVehicleType()==vehicleType) {
                        return spot;
                    }
                }
            }
        }
        throw new NoSpotAvailable("Currently No Spots available");
    }
}
