package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Volunteer;
import main.java.hostel.tool.TestData;
import main.java.hostel.tool.VolunteerBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VolunteerRepositorySmartImpl implements VolunteerRepository {

    private List<Volunteer> volunteers = new ArrayList<>();

    public VolunteerRepositorySmartImpl() {
        int length = TestData.getInstance().getVolunteerData().length;
        for (int i = 0; i < length; i++) {
            String[] splitedData = TestData.getInstance().getVolunteerData()[i].split(",");
            this.volunteers.add(
                    new VolunteerBuilder()
                            .withName(splitedData[1] + " " + splitedData[2])
                            .withCnp(splitedData[0])
                            .withOriginCountry(splitedData[3])
                            .build());

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
