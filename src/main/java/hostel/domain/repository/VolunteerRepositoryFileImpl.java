package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Volunteer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VolunteerRepositoryFileImpl implements VolunteerRepository {
    private Set<Volunteer> volunteers = new HashSet<Volunteer>();

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
    public Set<Volunteer> getVolunteers() {
        return volunteers;
    }}
