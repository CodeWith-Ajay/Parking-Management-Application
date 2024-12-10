package org.example.Services;

import org.example.Models.Vehicle;
import org.example.Models.VehicleType;
import org.example.Repositories.VehicleRepository;

public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository repository;
    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }
    @Override
    public Vehicle createOrget(String regNo, VehicleType type) {
        return repository.createOrGet(regNo, type);
    }
}
