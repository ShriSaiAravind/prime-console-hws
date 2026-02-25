package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BusPass {

    private int id;
    private Passenger passenger;
    private Route route;
    private String passType;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String status;

    public BusPass(int id, Passenger passenger, Route route,
                   String passType, LocalDate issueDate,
                   LocalDate expiryDate) {

        this.id = id;
        this.passenger = passenger;
        this.route = route;
        this.passType = passType;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.status = "ACTIVE";
    }

    @Override
    public String toString() {
        return "Pass ID: " + id +
                ", Passenger: " + passenger.getName() +
                ", Route: " + route.getSource() + "-" + route.getDestination() +
                ", Type: " + passType +
                ", Expiry: " + expiryDate +
                ", Status: " + status;
    }
}