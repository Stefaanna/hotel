package main.java.hostel.tool;

import main.java.hostel.domain.entity.Activity;

public class ActivityBuilder {

    private final Activity target = new Activity();

    public ActivityBuilder withTitle(String title) {
        target.setTitle(title);
        return this;
    }

    public ActivityBuilder withWeekDay(String day) {
        target.setWeekDay(day);
        return this;
    }

    public ActivityBuilder withStartingHour(int hour) {
        target.setStartingHour(hour);
        return this;
    }

    public Activity build() { return target; }

}
