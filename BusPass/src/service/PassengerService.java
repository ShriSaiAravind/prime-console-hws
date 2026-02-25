package service;

import model.Passenger;
import java.util.*;

public class PassengerService {

    private List<Passenger> passengers = new ArrayList<>();
    private int idCounter = 1;

    public Passenger register(String name, String category) {
        Passenger p = new Passenger(idCounter++, name, category);
        passengers.add(p);
        return p;
    }

    public Passenger getById(int id) {
        for (Passenger p : passengers) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void listAll() {
        for (Passenger p : passengers) {
            System.out.println(p);
        }
    }
}