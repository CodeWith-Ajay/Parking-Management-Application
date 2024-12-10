package org.example.Repositories;

import org.example.Models.Vehicle;
import org.example.Models.VehicleType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class VehicleRepoImpl implements VehicleRepository{
    Map<Integer,Vehicle>map;
    public VehicleRepoImpl() {
        map = new TreeMap<>();
    }
    @Override
    public Vehicle createOrGet(String regNo, VehicleType vehicleType) {
        for (Map.Entry<Integer, Vehicle> entry : map.entrySet()) {
        Vehicle vehicle = entry.getValue();
        if(vehicle.getRegNo().equals(regNo)){
            return vehicle;

        }
        }
        Vehicle vehicle=new Vehicle();
        vehicle.setRegNo(regNo);
        vehicle.setVehicleType(vehicleType);
        vehicle.setId(map.size()+1);
        map.put(vehicle.getId(), vehicle);
        return vehicle;
    }
}
