package xyz.codeframeworks.drones.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import xyz.codeframeworks.drones.model.Drone;
import xyz.codeframeworks.drones.model.Medication;
import xyz.codeframeworks.drones.service.DroneServiceImpl;

@RestController
public class DroneController {

    @Autowired
    DroneServiceImpl droneService;

    // ANSWER: registering a drone;
    @PostMapping("/drones")
    public ResponseEntity<?> registerDrone(@RequestBody Drone drone) {
        return ResponseEntity.ok(droneService.registerDrone(drone));
    }

    // ANSWER: loading a drone with medication items;
    @GetMapping("/drones/load/{id}")
    public ResponseEntity<?> loadDrone(@PathVariable("id") Long id, @RequestBody Set<Medication> medications) {
        return ResponseEntity.ok(droneService.loadDrone(id, medications));
    }

    // Getting Error
    // ANSWER: checking loaded medication items for a given drone;
    @GetMapping("/drones/loaded/{id}")
    public ResponseEntity<?> loadedDrone(@PathVariable("id") Long id) {
        return ResponseEntity.ok(droneService.loadedDrone(id));
    }

    // ANSWER: checking available drones for loading;
    @GetMapping("/drones/available")
    public ResponseEntity<?> getAvailableDrones() {
        return ResponseEntity.ok(droneService.getAvailableDrones());
    }

    // ANSWER: check drone battery level for a given drone;
    @GetMapping("/drones/battery/{id}")
    public ResponseEntity<?> getDrone(@PathVariable("id") Long id) {
        return ResponseEntity.ok(droneService.getDrone(id));
    }

    // ADDITIONAL: find all drones
    @GetMapping("/drones")
    public ResponseEntity<?> getDrones() {
        return ResponseEntity.ok(droneService.getDrones());
    }

}
