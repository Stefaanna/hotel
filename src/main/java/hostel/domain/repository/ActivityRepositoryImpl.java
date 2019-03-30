package main.java.hostel.domain.repository;

import main.java.hostel.configuration.RepositoryConfig;
import main.java.hostel.domain.entity.Activity;
import main.java.hostel.tool.ActivityBuilder;
import main.java.hostel.tool.TestData;

import static java.lang.Integer.parseInt;

public class ActivityRepositoryImpl implements ActivityRepository {

    Activity[] activities = new Activity[50];
    int currentIndex = 0;

    @Override
    public void addActivity(String title, String day, int hour) {
        activities[currentIndex++] = new Activity(title, day, hour);
    }


    /*
    //pentru SmartImpl
    public ActivityRepositoryImpl() {
        int length = TestData.getInstance().getActivityData().length;
        this.activities = new Activity[length];
        for (int i = 0; i < length; i++) {
            String[] splitedData = TestData.getInstance().getActivityData()[i].split(",");
            this.activities[i] =
                    new ActivityBuilder()
                            .withTitle(splitedData[0])
                            .withWeekDay(splitedData[1])
                            .withStartingHour(parseInt(splitedData[2]))
                            .build();

        }
    }*/

   @Override
    public void printAllActivities() {
        for (int i = 0; i < activities.length; i++) {
            if (activities[i] == null) {
                System.out.println("---------------------------------------------");
                break;
            }
            System.out.println(activities[i].getTitle() + ", which takes place on " + activities[i].getWeekDay() + " at " + activities[i].getStartingHour());
        }
    }


    @Override
    public Activity[] getActivities() {
        return activities;
    }
}
