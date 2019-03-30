package main.java.hostel.tool;

import main.java.hostel.domain.entity.Guest;

import java.util.Date;

public class GuestBuilder {

    private final Guest target = new Guest();

    public GuestBuilder withName(String name) {
        target.setName(name);
        return this;
    }

    public GuestBuilder withCnp(String cnp) {
        target.setCnp(cnp);
        return this;
    }

    public GuestBuilder withHireDate(Date date) {
        target.setComingDate(date);
        return this;
    }

    public GuestBuilder withLeavingDate(Date date) {
        target.setLeavingDate(date);
        return this;
    }

    public GuestBuilder withOriginCountry(String originCountry) {
        target.setOriginCountry(originCountry);
        return this;
    }

    public GuestBuilder withEmail(String email) {
        target.setEmail(email);
        return this;
    }

    public GuestBuilder withGender(String gender) {
        target.setGender(gender);
        return this;
    }


    public Guest build() { return target; }

}
