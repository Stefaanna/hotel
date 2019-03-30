package main.java.hostel.tool;

import main.java.hostel.domain.entity.Volunteer;

import java.util.Date;

public class VolunteerBuilder {

    private final Volunteer target = new Volunteer();

    public VolunteerBuilder withName(String name) {
        target.setName(name);
        return this;
    }

    public VolunteerBuilder withCnp(String cnp) {
        target.setCnp(cnp);
        return this;
    }

    public VolunteerBuilder withHireDate(Date date) {
        target.setHireDate(date);
        return this;
    }

    public VolunteerBuilder withLeavingDate(Date date) {
        target.setLeavingDate(date);
        return this;
    }

    public VolunteerBuilder withOriginCountry(String originCountry) {
        target.setOriginCountry(originCountry);
        return this;
    }



    public Volunteer build() { return target; }


}
