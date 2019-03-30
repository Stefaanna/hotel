package main.java.hostel.services;

import main.java.hostel.configuration.RepositoryConfig;
import main.java.hostel.domain.entity.Volunteer;
import main.java.hostel.domain.repository.VolunteerRepository;

public class VolunteerService {

    private VolunteerRepository volunteerRepository = RepositoryConfig.getInstance().getVolunteerRepository();

    public VolunteerService() {}

    private void printVolunteers(Volunteer[] result) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] == null) {
                System.out.println("--------------------------");
                break;
            }
            System.out.println(/*result[i].getCnp() + " " + */result[i].getName() + " from " + result[i].getOriginCountry());
        }
    }

    public void printAllVolunteers() { printVolunteers(volunteerRepository.getVolunteers()); }


}
