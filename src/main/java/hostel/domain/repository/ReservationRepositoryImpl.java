package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Guest;
import main.java.hostel.domain.entity.Reservation;
import main.java.hostel.services.AuditService;

public class ReservationRepositoryImpl implements ReservationRepository {

    Reservation[] reservations = new Reservation[50];
    int currentIndex = 0;
    private AuditService auditService = AuditService.getInstance();


    @Override
    public Reservation[] getReservations() {
        return reservations;
    }

    @Override
    public void addReservation(Guest guest) {
        auditService.printActionsDetails("addReservation");
        reservations[currentIndex++] = new Reservation(guest);
    }
}
