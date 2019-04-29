package main.java.hostel.services;

import main.java.hostel.configuration.RepositoryConfig;
import main.java.hostel.domain.entity.Volunteer;
import main.java.hostel.domain.repository.VolunteerRepository;

import java.util.Set;

public class VolunteerService {

    private VolunteerRepository volunteerRepository = RepositoryConfig.getInstance().getVolunteerRepository();

    public VolunteerService() {}

    private void printVolunteers(Set<Volunteer> result) {
        for (Volunteer v : result) {
            System.out.println(v.getName() + " from " + v.getOriginCountry());
        }
    }

    public void printAllVolunteers() { printVolunteers(volunteerRepository.getVolunteers()); }


}
