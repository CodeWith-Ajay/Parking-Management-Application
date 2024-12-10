package org.example.Repositories;

import org.example.Models.Floor;
import org.example.Models.Gate;
import org.example.Models.ParkingLot;

import java.util.Map;
import java.util.TreeMap;

public class ParkingLotRepoImpl implements ParkingRepository{
    private Map<Integer, ParkingLot>map;

    public ParkingLotRepoImpl(Map<Integer, ParkingLot> map) {
        this.map = map;
    }

    public ParkingLotRepoImpl() {
        map= new TreeMap<>();
    }
    public ParkingLot getByGateId(int gateId) {
        for (Map.Entry<Integer, ParkingLot> entry : map.entrySet()) {
            ParkingLot parkingLot=entry.getValue();
            for(Floor floor:parkingLot.getFloors()) {
                for (Gate gate : floor.getGates()) {
                    if(gate.getId()==gateId){
                        return parkingLot;
                    }
                }
            }
        }return  null;
    }
}
