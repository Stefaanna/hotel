package main.java.hostel.domain.entity;

public class Reservation {
    private Guest guest;
    private int bedNumber;
    private int roomNumber;
    private int reservationNumber;

    public Reservation() {}

    public Reservation(Guest guest) {
        this.setGuest(guest);
    }

    private void setGuest(Guest guest) {
        this.guest = guest;
    }
}
