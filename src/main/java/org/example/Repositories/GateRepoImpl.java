package org.example.Repositories;

import org.example.Models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GateRepoImpl implements GateRepository{
    private Map<Integer, Gate> map;
    public GateRepoImpl() {
        map = new TreeMap<>();
    }
    public GateRepoImpl(Map<Integer, Gate> map) {
        this.map = map;
    }

    @Override
    public Gate getByGateId(int gateId) {
        return map.get(gateId);
    }
}
