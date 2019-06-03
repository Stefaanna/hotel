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
    public void addActivity(String title, String weekday, int hour) {
        activities.add(new Activity(title, weekday, hour));
    }

    @Override
    public Set<Activity> getActivities() {
        return activities;
    }

    public void insertActivity(Activity activity) {
       activities.add(activity);
    }

    public void updateActivity(String title, String weekday) {
        // update the weekday of the activity
        Activity lastActivity = null;
        for (Activity a : activities) {
            if (a.getTitle().equals(title)) {
                lastActivity = a;
            }
        }
        lastActivity.setWeekDay(weekday);
    }

    public void deleteActivity(Activity activity) {
        activities.remove(activity);
    }
}
