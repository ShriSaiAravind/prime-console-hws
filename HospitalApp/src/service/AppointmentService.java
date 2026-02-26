package service;

import model.*;
import java.time.LocalDate;
import java.util.*;

public class AppointmentService {

    private List<Appointment> appointments = new ArrayList<>();
    private int idCounter = 1;

    public Appointment book(User patient, Doctor doctor, LocalDate date) {

        for (Appointment a : appointments) {
            if (a.getDoctor().getId() == doctor.getId() &&
                a.getDate().equals(date) &&
                a.getStatus().equals("BOOKED")) {

                System.out.println("Doctor not available on that date.");
                return null;
            }
        }

        Appointment appointment =
                new Appointment(idCounter++, patient, doctor, date);

        appointments.add(appointment);
        return appointment;
    }

    public void cancel(int appointmentId) {
        for (Appointment a : appointments) {
            if (a.getId() == appointmentId &&
                a.getStatus().equals("BOOKED")) {

                a.setStatus("CANCELLED");
                System.out.println("Appointment cancelled.");
                return;
            }
        }
        System.out.println("Invalid appointment.");
    }

    public void listAll() {
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }
}