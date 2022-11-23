package xyz.codeframeworks.drones.repository;

import org.springframework.data.repository.CrudRepository;

import xyz.codeframeworks.drones.model.Drone;

public interface DroneRepository extends CrudRepository<Drone, Long> {
    
}
