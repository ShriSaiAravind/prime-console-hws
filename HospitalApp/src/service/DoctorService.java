package service;

import model.Doctor;
import java.util.*;

public class DoctorService {

    private List<Doctor> doctors = new ArrayList<>();

    public DoctorService() {
        doctors.add(new Doctor(1, "Ramesh", "Cardiology"));
        doctors.add(new Doctor(2, "Sita", "Dermatology"));
        doctors.add(new Doctor(3, "Arun", "Orthopedics"));
    }

    public List<Doctor> getAll() {
        return doctors;
    }

    public Doctor getById(int id) {
        for (Doctor d : doctors) {
            if (d.getId() == id) return d;
        }
        return null;
    }
}