package org.example.Models;

import java.util.List;

public class Floor {
    private int id;
    List<Spot>spots;
    List<Gate>gates;
    private FloorStatus floorstatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public FloorStatus getFloorstatus() {
        return floorstatus;
    }

    public void setFloorstatus(FloorStatus floorstatus) {
        this.floorstatus = floorstatus;
    }



}
