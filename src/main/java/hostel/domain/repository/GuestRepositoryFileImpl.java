package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Employee;
import main.java.hostel.domain.entity.Guest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GuestRepositoryFileImpl implements GuestRepository {
    private ArrayList<Guest> guests = new ArrayList<Guest>();

    public GuestRepositoryFileImpl(String filename) throws FileNotFoundException {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            Guest newEntry = new Guest(values[1], values[0], values[2]); // values[0] -> Name; values[1] -> CNP; values[2] -> originCountry
            guests.add(newEntry);
        }
    }

    @Override
    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void insertGuest(Guest guest) {
        guests.add(guest);
    }

    public void updateGuest(String cnp, String name, String originCountry) {
        // update the name and origin country of a guest
        Guest lastGuest = null;
        for (Guest g : guests) {
            if (g.getCnp().equals(cnp)) {
                lastGuest = g;
            }
        }
        lastGuest.setName(name);
        lastGuest.setOriginCountry(originCountry);
    }

    public void deleteGuest(Guest guest) {
        guests.remove(guest);
    }
}

