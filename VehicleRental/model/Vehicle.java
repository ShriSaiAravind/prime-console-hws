package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {

    private int id;
    private String name;
    private String type;
    private double pricePerDay;

    public Vehicle(int id, String name, String type, double pricePerDay) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + type + ") - ₹" + pricePerDay + "/day";
    }
}
