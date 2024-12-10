package org.example.Services;

import org.example.Models.Gate;
import org.example.Repositories.GateRepository;

public class GateServiceImpl implements GateService {
    GateRepository gateRepository;

    public GateServiceImpl(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    @Override
    public Gate getGate(int id) {
        return gateRepository.getByGateId(id);
    }
}
