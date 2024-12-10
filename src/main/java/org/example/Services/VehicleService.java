package org.example.Services;

import org.example.Models.Vehicle;
import org.example.Models.VehicleType;

public interface VehicleService {
    public Vehicle createOrget(String regNo, VehicleType type);
}
