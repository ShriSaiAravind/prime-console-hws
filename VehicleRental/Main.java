import service.*;
import model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        VehicleService vehicleService = new VehicleService();
        BookingService bookingService = new BookingService();

        while (true) {

            System.out.println("\n1. Register Customer");
            System.out.println("2. View Vehicles");
            System.out.println("3. Book Vehicle");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Customer customer = customerService.register(name, email);
                    System.out.println("Registered: " + customer);
                    break;

                case 2:
                    vehicleService.getAll().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Customer ID: ");
                    int custId = sc.nextInt();
                    Customer c = customerService.getById(custId);

                    if (c == null) {
                        System.out.println("Invalid customer.");
                        break;
                    }

                    System.out.print("Vehicle ID: ");
                    int vehId = sc.nextInt();
                    Vehicle v = vehicleService.getById(vehId);

                    if (v == null) {
                        System.out.println("Invalid vehicle.");
                        break;
                    }

                    System.out.print("Start date (YYYY-MM-DD): ");
                    LocalDate start = LocalDate.parse(sc.next());
                    System.out.print("End date (YYYY-MM-DD): ");
                    LocalDate end = LocalDate.parse(sc.next());

                    Booking booking = bookingService.create(c, v, start, end);

                    if (booking != null)
                        System.out.println("Booking successful: " + booking);

                    break;

                case 4:
                    bookingService.listAll();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid option.");
            }
            
        sc.close();
        }
    }
}
