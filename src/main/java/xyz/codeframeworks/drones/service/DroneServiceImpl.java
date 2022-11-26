package xyz.codeframeworks.drones.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xyz.codeframeworks.drones.model.Drone;
import xyz.codeframeworks.drones.model.DroneState;
import xyz.codeframeworks.drones.model.Medication;
import xyz.codeframeworks.drones.repository.DroneRepository;

@Slf4j
@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    DroneRepository droneRepository;

    @Value("${app.battery.minimum}")
    private Double batteryLevel;

    public Iterable<Drone> getAvailableDrones() {
        return droneRepository.findByBatteryPercentageGreaterThanAndStateEquals(batteryLevel, DroneState.IDLE);
    }

    public Iterable<Drone> getDrones() {
        return droneRepository.findAll();
    }

    public Drone registerDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public Map<String, String> getDrone(Long id) {
        Optional<Drone> dOptional = droneRepository.findById(id);
        Double batteryPercentage = dOptional.get().getBatteryPercentage();
        String loadable;
        if (batteryPercentage > batteryLevel)
            loadable = "Can load medication";
        else
            loadable = "Can't load medication";
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id.toString());
        map.put("bateryPercentage", batteryPercentage.toString());
        map.put("loadingMedication", loadable);
        return map;
    }

    public Drone loadDrone(Long id, Set<Medication> medications) {
        Drone drone = droneRepository.findById(id).get();
        drone.setMedications(medications);
        droneRepository.save(drone);
        return drone;
    }

    public Set<Medication> loadedDrone(Long id) {
        return droneRepository.findById(id).get().getMedications();
    }
}
