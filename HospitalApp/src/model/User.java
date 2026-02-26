package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int id;
    private String name;
    private String role;      // PATIENT / ADMIN
    private String password;

    public User(int id, String name, String role, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + role + ")";
    }
}