import service.*;
import model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService userService = new UserService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService = new AppointmentService();

        System.out.println("Login");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        User currentUser = userService.login(username, password);

        if (currentUser == null) {
            System.out.println("Invalid login.");
            sc.close();
            return;
        }

        while (true) {

            System.out.println("\n1. Book Appointment");
            System.out.println("2. Cancel Appointment");
            System.out.println("3. View Appointments");
            if (currentUser.getRole().equals("ADMIN")) {
                System.out.println("4. View Users");
            }
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    doctorService.getAll().forEach(System.out::println);

                    System.out.print("Doctor ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();

                    Doctor doctor = doctorService.getById(did);
                    if (doctor == null) {
                        System.out.println("Invalid doctor.");
                        break;
                    }

                    System.out.print("Date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());

                    System.out.println("Booked: " +
                            appointmentService.book(currentUser, doctor, date));
                    break;

                case 2:
                    System.out.print("Appointment ID: ");
                    appointmentService.cancel(sc.nextInt());
                    break;

                case 3:
                    appointmentService.listAll();
                    break;

                case 4:
                    if (currentUser.getRole().equals("ADMIN"))
                        userService.listUsers();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
            sc.close();
        }
    }
}