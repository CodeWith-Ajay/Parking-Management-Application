package org.example.Services;

import org.example.Models.ParkingLot;
import org.example.Repositories.ParkingLotRepoImpl;
import org.example.Repositories.ParkingRepository;

public class ParkingServiceImpl implements ParkingLotService{
    ParkingRepository parkingRepo;

    public ParkingServiceImpl(ParkingRepository parkingRepo) {
        this.parkingRepo = parkingRepo;
    }

    @Override
    public ParkingLot getParkingLotByGateId(int id) {
        return parkingRepo.getByGateId(id);
    }
}
