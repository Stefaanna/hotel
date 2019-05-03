package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Activity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ActivityRepositoryFileImpl implements ActivityRepository {

    Set<Activity> activities = new TreeSet<Activity>(new Comparator<Activity>() {
        @Override
        public int compare(Activity a1, Activity a2) {
            if (a1.getTitle().equals(a2.getTitle())) {
                return a1.getWeekDay().compareToIgnoreCase(a2.getWeekDay());
            }
            return a1.getTitle().compareToIgnoreCase(a2.getTitle());

        }
    });

    public ActivityRepositoryFileImpl(String filename) throws FileNotFoundException {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            Activity newEntry = new Activity(values[0], values[1]); // values[0] -> title; values[1] -> day
            activities.add(newEntry);
        }
    }

    @Override
    public void addActivity(String title, String day, int hour) {
        activities.add(new Activity(title, day, hour));
    }

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
