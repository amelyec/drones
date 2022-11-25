package xyz.codeframeworks.drones.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import xyz.codeframeworks.drones.model.Drone;
import xyz.codeframeworks.drones.model.DroneState;
import xyz.codeframeworks.drones.repository.DroneRepository;

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
        if(batteryPercentage > batteryLevel) loadable = "Can load medication"; else loadable = "Can't load medication";
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id.toString());
        map.put("bateryPercentage", batteryPercentage.toString());
        map.put("loadingMedication", loadable);
        return map;
    }
}
