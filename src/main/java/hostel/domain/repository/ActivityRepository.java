package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Activity;

public interface ActivityRepository {

    public Activity[] getActivities();

    public void addActivity(String title, String day, int hour);

    public void printAllActivities();
}
