package main.java.hostel.tool;

import main.java.hostel.domain.entity.Activity;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ActivityGenerator {

    public static void writeActivityData() {

        try {
            FileWriter fileWriter = new FileWriter("D:\\Facultate\\2.2\\PAO\\lab\\hotel\\src\\main\\java\\hostel\\data\\activities.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            /*Activity activity = new ActivityBuilder().withTitle("yoga").withWeekDay("saturday").build();
            printWriter.print(activity.getTitle());
            printWriter.print(",");
            printWriter.print(activity.getWeekDay());
            printWriter.println();*/

            Set<Activity> activities = new TreeSet<Activity>(new Comparator<Activity>() {
                @Override
                public int compare(Activity a1, Activity a2) {

                    if (a1.getTitle().equals(a2.getTitle())) {
                        return a1.getWeekDay().compareToIgnoreCase(a2.getWeekDay());
                    }
                    return a1.getTitle().compareToIgnoreCase(a2.getTitle());
                }
            });

            activities.add(new ActivityBuilder().withTitle("singing").withWeekDay("saturday").build());
            activities.add(new ActivityBuilder().withTitle("drawing").withWeekDay("monday").build());
            activities.add(new ActivityBuilder().withTitle("yoga").withWeekDay("saturday").build());
            activities.add(new ActivityBuilder().withTitle("yoga").withWeekDay("sunday").build());
            activities.add(new ActivityBuilder().withTitle("singing").withWeekDay("saturday").build());

            for (Activity activity : activities) {
                printWriter.print(activity.getTitle());
                printWriter.print(",");
                printWriter.print(activity.getWeekDay());
                printWriter.println();
            }

            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
