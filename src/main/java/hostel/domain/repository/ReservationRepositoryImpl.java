package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Guest;
import main.java.hostel.domain.entity.Reservation;

public class ReservationRepositoryImpl implements ReservationRepository {

    Reservation[] reservations = new Reservation[50];
    int currentIndex = 0;


    @Override
    public Reservation[] getReservations() {
        return reservations;
    }

    @Override
    public void addReservation(Guest guest) {
        reservations[currentIndex++] = new Reservation(guest);
    }
}
