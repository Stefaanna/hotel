package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Volunteer;
import main.java.hostel.tool.TestData;
import main.java.hostel.tool.VolunteerBuilder;

public class VolunteerRepositorySmartImpl implements VolunteerRepository {

    private Volunteer[] volunteers;

    public VolunteerRepositorySmartImpl() {
        int length = TestData.getInstance().getVolunteerData().length;
        this.volunteers = new Volunteer[length];
        for (int i = 0; i < length; i++) {
            String[] splitedData = TestData.getInstance().getVolunteerData()[i].split(",");
            this.volunteers[i] =
                    new VolunteerBuilder()
                            .withName(splitedData[1] + " " + splitedData[2])
                            .withCnp(splitedData[0])
                            .withOriginCountry(splitedData[3])
                            .build();

        }
    }

    @Override
    public Volunteer[] getVolunteers() {
        return volunteers;
    }
}
