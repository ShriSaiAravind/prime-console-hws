package service;

import model.User;
import java.util.*;

public class UserService {

    private List<User> users = new ArrayList<>();
    private int idCounter = 1;

    public UserService() {
        users.add(new User(idCounter++, "Admin", "ADMIN", "admin"));
    }

    public User register(String name, String password) {
        User user = new User(idCounter++, name, "PATIENT", password);
        users.add(user);
        return user;
    }

    public User login(String name, String password) {
        for (User u : users) {
            if (u.getName().equals(name) &&
                u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void listUsers() {
        for (User u : users) {
            System.out.println(u);
        }
    }
}