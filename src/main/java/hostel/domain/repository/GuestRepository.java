package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Guest;

import java.util.ArrayList;

public interface GuestRepository {
    public ArrayList<Guest> getGuests();

    void insertGuest(Guest guest);

    void updateGuest(String cnp, String name, String originCountry);

    void deleteGuest(Guest guest);
}
