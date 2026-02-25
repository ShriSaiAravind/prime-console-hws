package service;

import model.Vehicle;
import java.util.*;

public class VehicleService {

    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleService() {
        vehicles.add(new Vehicle(1, "Honda City", "Car", 2000));
        vehicles.add(new Vehicle(2, "Hyundai i20", "Car", 1800));
        vehicles.add(new Vehicle(3, "Yamaha R15", "Bike", 800));
    }

    public List<Vehicle> getAll() {
        return vehicles;
    }

    public Vehicle getById(int id) {
        return vehicles.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
