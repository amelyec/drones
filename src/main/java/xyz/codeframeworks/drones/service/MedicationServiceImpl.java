package xyz.codeframeworks.drones.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xyz.codeframeworks.drones.model.Medication;
import xyz.codeframeworks.drones.repository.MedicationRepository;
@Slf4j
@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    MedicationRepository medicationRepository;

    public Optional<Medication> createMedication(Medication medication) {
        return Optional.of(medicationRepository.save(medication));
    }

    public Iterable<Medication> getMedications() {
        return medicationRepository.findAll();
    }
}
