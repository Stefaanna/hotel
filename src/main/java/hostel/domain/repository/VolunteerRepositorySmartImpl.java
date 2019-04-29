package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Volunteer;
import main.java.hostel.tool.data.TestData;
import main.java.hostel.tool.VolunteerBuilder;

import java.util.HashSet;
import java.util.Set;

public class VolunteerRepositorySmartImpl implements VolunteerRepository {

    private Set<Volunteer> volunteers = new HashSet<Volunteer>();

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
    public Set<Volunteer> getVolunteers() {
        return volunteers;
    }
}
