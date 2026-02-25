package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger {

    private int id;
    private String name;
    private String category;

    public Passenger(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + category + ")";
    }
}