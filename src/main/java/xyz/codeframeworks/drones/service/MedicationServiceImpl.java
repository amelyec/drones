package xyz.codeframeworks.drones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.codeframeworks.drones.model.Drone;
import xyz.codeframeworks.drones.repository.DroneRepository;

@Service
public class MedicationServiceImpl implements MedicationService {
    @Autowired
    DroneRepository droneRepository;
    
    public Drone registerDrone(Drone drone) {
        return droneRepository.save(drone);
    }
}
