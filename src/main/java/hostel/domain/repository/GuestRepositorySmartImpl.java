package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Guest;
import main.java.hostel.domain.repository.GuestRepository;
import main.java.hostel.tool.GuestBuilder;
import main.java.hostel.tool.TestData;

public class GuestRepositorySmartImpl implements GuestRepository {

    private Guest[] guests;

    public GuestRepositorySmartImpl() {
        int length = TestData.getInstance().getGuestData().length;
        this.guests = new Guest[length];
        for (int i = 0; i < length; i++) {
            String[] splitedData = TestData.getInstance().getGuestData()[i].split(",");
            this.guests[i] =
                    new GuestBuilder()
                            .withName(splitedData[1] + " " + splitedData[2])
                            .withCnp(splitedData[0])
                            .withEmail(splitedData[3])
                            .withGender(splitedData[4])
                            .withOriginCountry(splitedData[5])
                            .build();

        }
    }

    @Override
    public Guest[] getGuests() {
        return guests;
    }

}
