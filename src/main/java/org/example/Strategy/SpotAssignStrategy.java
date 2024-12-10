package org.example.Strategy;

import org.example.Exceptions.NoSpotAvailable;
import org.example.Models.Floor;
import org.example.Models.Spot;
import org.example.Models.VehicleType;

import java.util.List;

public interface SpotAssignStrategy {
    public Spot findAvailableSpot(List<Floor> floors, VehicleType vehicleType) throws NoSpotAvailable;
}
