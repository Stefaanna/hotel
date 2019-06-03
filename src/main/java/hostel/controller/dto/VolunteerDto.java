package main.java.hostel.controller.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.java.hostel.domain.entity.Volunteer;

public class VolunteerDto {
    public StringProperty cnp;
    public StringProperty name;
    public StringProperty originCountry;

    public VolunteerDto() {

    }

    public VolunteerDto(Volunteer volunteer) {
        if (volunteer == null) {
            return;
        }
        this.cnp = new SimpleStringProperty(volunteer.getCnp());
        this.name = new SimpleStringProperty(volunteer.getName());
        this.originCountry = new SimpleStringProperty(volunteer.getOriginCountry());
    }

    public StringProperty cnpProperty() { return cnp; }

    public StringProperty nameProperty() { return name; }

    public StringProperty originCountryProperty() { return originCountry; }
}
