package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Guest;
import main.java.hostel.domain.entity.Reservation;

public interface ReservationRepository {
    public Reservation[] getReservations();

    public void addReservation(Guest guest);

}
