package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Volunteer;

import java.util.List;
import java.util.Set;

public interface VolunteerRepository {

    public List<Volunteer> getVolunteers();

    void insertVolunteer(Volunteer volunteer);

    void updateUser(String cnp, String name, String originCountry);

    void deleteVolunteer(Volunteer volunteer);
}
