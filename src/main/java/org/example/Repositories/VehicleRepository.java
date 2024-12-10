package org.example.Repositories;

import org.example.Models.Vehicle;
import org.example.Models.VehicleType;

public interface VehicleRepository {
    public Vehicle createOrGet(String regNo, VehicleType vehicleType);
}
