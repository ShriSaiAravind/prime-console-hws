package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Booking {

    private int id;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;
    private boolean active;

    public Booking(int id, Customer customer, Vehicle vehicle,
                   LocalDate startDate, LocalDate endDate,
                   double totalCost) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.active = true;
    }

    @Override
    public String toString() {
        return "Booking ID: " + id +
                ", Vehicle: " + vehicle.getName() +
                ", Customer: " + customer.getName() +
                ", Total: ₹" + totalCost +
                ", Active: " + active;
    }
}
