package xyz.codeframeworks.drones.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import xyz.codeframeworks.drones.model.Medication;
import xyz.codeframeworks.drones.service.MedicationServiceImpl;

@RestController
public class MedicationController {

    @Autowired
    MedicationServiceImpl medicationService;

    // ADDITIONAL: find all drones
    @GetMapping("/medications")
    public ResponseEntity<?> getMedications() {
        return ResponseEntity.ok(medicationService.getMedications());
    }

    // ADDITIONAL: registering a drone;
    @PostMapping("/medications")
    public ResponseEntity<?> registerDrone(@Valid @RequestBody Medication medication) {
        return ResponseEntity.ok(medicationService.createMedication(medication));
    }

}
