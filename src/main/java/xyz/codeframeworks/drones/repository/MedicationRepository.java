package xyz.codeframeworks.drones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import xyz.codeframeworks.drones.model.Medication;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Long> {

}
