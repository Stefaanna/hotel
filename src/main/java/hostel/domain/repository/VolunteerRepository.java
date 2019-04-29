package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Volunteer;

import java.util.Set;

public interface VolunteerRepository {

    public Set<Volunteer> getVolunteers();

}
