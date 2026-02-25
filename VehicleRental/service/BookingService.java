package service;

import model.*;
import java.time.LocalDate;
import java.util.*;

public class BookingService {

    private List<Booking> bookings = new ArrayList<>();
    private int idCounter = 1;

    public Booking create(Customer customer, Vehicle vehicle,
                          LocalDate start, LocalDate end) {

        for (Booking b : bookings) {
            if (b.getVehicle().getId() == vehicle.getId() && b.isActive()) {
                System.out.println("Vehicle already booked.");
                return null;
            }
        }

        long days = end.toEpochDay() - start.toEpochDay();

        if (days <= 0) {
            System.out.println("Invalid dates.");
            return null;
        }

        double total = days * vehicle.getPricePerDay();

        Booking booking = new Booking(
                idCounter++, customer, vehicle, start, end, total
        );

        bookings.add(booking);
        return booking;
    }

    public void listAll() {
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}
