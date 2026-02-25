import service.*;
import model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PassengerService passengerService = new PassengerService();
        RouteService routeService = new RouteService();
        BusPassService passService = new BusPassService();

        while (true) {

            passService.updateExpiry();

            System.out.println("\n1. Register Passenger");
            System.out.println("2. Issue Pass");
            System.out.println("3. Renew Pass");
            System.out.println("4. Cancel Pass");
            System.out.println("5. View Passes");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.println("Registered: " +
                            passengerService.register(name, category));
                    break;

                case 2:
                    System.out.print("Passenger ID: ");
                    int pid = sc.nextInt();
                    Passenger passenger = passengerService.getById(pid);

                    if (passenger == null) {
                        System.out.println("Invalid passenger.");
                        break;
                    }

                    routeService.listAll();
                    System.out.print("Route ID: ");
                    int rid = sc.nextInt();
                    Route route = routeService.getById(rid);

                    if (route == null) {
                        System.out.println("Invalid route.");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Pass Type (Student/Monthly/Senior): ");
                    String passType = sc.nextLine();

                    System.out.print("Validity (days): ");
                    int days = sc.nextInt();

                    System.out.println("Issued: " +
                            passService.issue(passenger, route, passType, days));
                    break;

                case 3:
                    System.out.print("Pass ID: ");
                    passService.renew(sc.nextInt(), 30);
                    break;

                case 4:
                    System.out.print("Pass ID: ");
                    passService.cancel(sc.nextInt());
                    break;

                case 5:
                    passService.listAll();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid option.");
            }
    
        sc.close();
        }
    }
}