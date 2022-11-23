package xyz.codeframeworks.drones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import xyz.codeframeworks.drones.model.Drone;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {
    
}
