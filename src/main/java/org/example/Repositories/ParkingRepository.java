package org.example.Repositories;

import org.example.Models.ParkingLot;

public interface ParkingRepository {
    public ParkingLot getByGateId(int gateId);
}
