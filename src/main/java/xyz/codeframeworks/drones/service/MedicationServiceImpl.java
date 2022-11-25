package xyz.codeframeworks.drones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.codeframeworks.drones.model.Medication;
import xyz.codeframeworks.drones.repository.MedicationRepository;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    MedicationRepository medicationRepository;

    public Medication createMedication(Medication medication) {
        return medicationRepository.save(medication);
    }
}
