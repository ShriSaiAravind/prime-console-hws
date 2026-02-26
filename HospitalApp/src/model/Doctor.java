package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doctor {

    private int id;
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return id + " - Dr." + name + " (" + specialization + ")";
    }
}