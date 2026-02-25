package service;

import model.Customer;
import java.util.*;

public class CustomerService {

    private List<Customer> customers = new ArrayList<>();
    private int idCounter = 1;

    public Customer register(String name, String email) {
        Customer customer = new Customer(idCounter++, name, email);
        customers.add(customer);
        return customer;
    }

    public Customer getById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void listAll() {
        customers.forEach(System.out::println);
    }
}
