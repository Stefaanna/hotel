package main.java.hostel.domain.entity;

public class Activity {

    private String title;
    private String weekDay;
    private int startingHour;

    public Activity() {}

    public Activity(String title, String day, int hour) {
        this.setTitle(title);
        this.setWeekDay(day);
        this.setStartingHour(hour);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWeekDay(String day) {
        this.weekDay = day;
    }

    public void setStartingHour(int hour) {
        this.startingHour = hour;
    }

    public String getTitle() {
        return title;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public int getStartingHour() {
        return startingHour;
    }
}
