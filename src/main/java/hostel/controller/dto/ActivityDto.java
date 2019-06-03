package main.java.hostel.controller.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.java.hostel.domain.entity.Activity;

public class ActivityDto {
    public StringProperty title;
    public StringProperty weekday;

    public ActivityDto() {

    }

    public ActivityDto(Activity activity) {
        if (activity == null) {
            return;
        }
        this.title = new SimpleStringProperty(activity.getTitle());
        this.weekday = new SimpleStringProperty(activity.getWeekDay());
    }

    public StringProperty weekdayProperty() { return weekday; }

    public StringProperty titleProperty() { return title; }
}
