package xyz.codeframeworks.drones.repository;

import org.springframework.data.repository.CrudRepository;

import xyz.codeframeworks.drones.model.Medication;

public interface MedicationRepository extends CrudRepository<Medication, Long> {
    
}
