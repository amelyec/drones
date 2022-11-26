package xyz.codeframeworks.drones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import xyz.codeframeworks.drones.model.Drone;
import xyz.codeframeworks.drones.model.DroneState;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {

    Iterable<Drone> findByBatteryPercentageGreaterThanAndStateEquals(Double batteryLevel, DroneState state);

}
