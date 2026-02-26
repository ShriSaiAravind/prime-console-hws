package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Appointment {

    private int id;
    private User patient;
    private Doctor doctor;
    private LocalDate date;
    private String status;   // BOOKED / CANCELLED

    public Appointment(int id, User patient, Doctor doctor, LocalDate date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = "BOOKED";
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id +
                ", Patient: " + patient.getName() +
                ", Doctor: Dr." + doctor.getName() +
                ", Date: " + date +
                ", Status: " + status;
    }
}