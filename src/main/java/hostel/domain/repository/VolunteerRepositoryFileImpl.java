package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Volunteer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class VolunteerRepositoryFileImpl implements VolunteerRepository {
    private List<Volunteer> volunteers = new ArrayList<Volunteer>();

    public VolunteerRepositoryFileImpl(String filename) throws FileNotFoundException {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            Volunteer newEntry = new Volunteer(values[1], values[0], values[2]); // values[0] -> Name; values[1] -> CNP; values[2] -> origin country
            volunteers.add(newEntry);
        }
    }

    @Override
    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    @Override
    public void insertVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    @Override
    public void updateUser(String cnp, String name, String originCountry) {
        Volunteer lastVolunteer = volunteers.get(volunteers.size());
        lastVolunteer.setName(name);
        lastVolunteer.setCnp(cnp);
        lastVolunteer.setOriginCountry(originCountry);
    }

    public void deleteVolunteer(Volunteer volunteer) {
        volunteers.remove(volunteer);
    }
}

