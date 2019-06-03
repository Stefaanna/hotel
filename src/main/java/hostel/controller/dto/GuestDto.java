package main.java.hostel.controller.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.java.hostel.domain.entity.Guest;

public class GuestDto {
    public StringProperty cnp;
    public StringProperty name;
    public StringProperty originCountry;

    public GuestDto() {

    }

    public GuestDto(Guest guest) {
        if (guest == null) {
            return;
        }
        this.cnp = new SimpleStringProperty(guest.getCnp());
        this.name = new SimpleStringProperty(guest.getName());
        this.originCountry = new SimpleStringProperty(guest.getOriginCountry());
    }

    public StringProperty cnpProperty() { return cnp; }

    public StringProperty nameProperty() { return name; }

    public StringProperty originCountryProperty() { return originCountry; }
}
