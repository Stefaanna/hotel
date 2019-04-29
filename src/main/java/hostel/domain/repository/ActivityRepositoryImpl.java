package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Activity;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class ActivityRepositoryImpl implements ActivityRepository {

    Set<Activity> activities = new TreeSet<Activity>(new Comparator<Activity>() {
        @Override
        public int compare(Activity a1, Activity a2) {

            if (a1.getTitle().equals(a2.getTitle())) {
                return a1.getWeekDay().compareToIgnoreCase(a2.getWeekDay());
            }
            return a1.getTitle().compareToIgnoreCase(a2.getTitle());
        }
    });

    @Override
    public void addActivity(String title, String day, int hour) {
        activities.add(new Activity(title, day, hour));
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
        for (Activity a : activities) {
            System.out.println(a.getTitle() + ", which takes place on " + a.getWeekDay());
        }
        System.out.println();
    }


    @Override
    public Set<Activity> getActivities() {
        return activities;
    }
}
