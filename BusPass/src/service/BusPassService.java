package service;

import model.*;
import java.time.LocalDate;
import java.util.*;

public class BusPassService {

    private List<BusPass> passes = new ArrayList<>();
    private int idCounter = 1;

    public BusPass issue(Passenger passenger,
                         Route route,
                         String passType,
                         int validityDays) {

        for (BusPass p : passes) {
            if (p.getPassenger().getId() == passenger.getId()
                    && p.getStatus().equals("ACTIVE")) {

                System.out.println("Passenger already has active pass.");
                return null;
            }
        }

        LocalDate issueDate = LocalDate.now();
        LocalDate expiryDate = issueDate.plusDays(validityDays);

        BusPass pass = new BusPass(
                idCounter++, passenger, route,
                passType, issueDate, expiryDate
        );

        passes.add(pass);
        return pass;
    }

    public void renew(int passId, int validityDays) {
        for (BusPass p : passes) {
            if (p.getId() == passId &&
                p.getStatus().equals("EXPIRED")) {

                p.setIssueDate(LocalDate.now());
                p.setExpiryDate(LocalDate.now().plusDays(validityDays));
                p.setStatus("ACTIVE");
                System.out.println("Pass renewed.");
                return;
            }
        }
        System.out.println("Cannot renew pass.");
    }

    public void cancel(int passId) {
        for (BusPass p : passes) {
            if (p.getId() == passId &&
                p.getStatus().equals("ACTIVE")) {

                p.setStatus("CANCELLED");
                System.out.println("Pass cancelled.");
                return;
            }
        }
        System.out.println("Cannot cancel pass.");
    }

    public void updateExpiry() {
        LocalDate today = LocalDate.now();
        for (BusPass p : passes) {
            if (p.getStatus().equals("ACTIVE") &&
                p.getExpiryDate().isBefore(today)) {

                p.setStatus("EXPIRED");
            }
        }
    }

    public void listAll() {
        for (BusPass p : passes) {
            System.out.println(p);
        }
    }
}