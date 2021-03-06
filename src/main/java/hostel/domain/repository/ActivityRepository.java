package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Activity;

import java.util.Set;

public interface ActivityRepository {

    public Set<Activity> getActivities();

    public void addActivity(String title, String day, int hour);

    void insertActivity(Activity activity);

    void updateActivity(String title, String weekday);

    void deleteActivity(Activity activity);

}
