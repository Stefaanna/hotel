package main.java.hostel.services;

import main.java.hostel.configuration.RepositoryConfig;
import main.java.hostel.controller.dto.ActivityDto;
import main.java.hostel.domain.entity.Activity;
import main.java.hostel.domain.entity.Employee;
import main.java.hostel.domain.repository.ActivityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActivityService {

    private ActivityRepository activityRepository = RepositoryConfig.getInstance().getActivityRepository();
    AuditService auditService = AuditService.getInstance();

    public ActivityService() {
    }

    public void addActivity(String title, String day, int hour) {
        auditService.printActionsDetails("addActivity");
        activityRepository.addActivity(title, day, hour);
    }

    private void printActivities(Set<Activity> activities) {
        for (Activity a : activities) {
            System.out.println(a.getTitle() + ", which takes place on " + a.getWeekDay());
        }
        System.out.println();
    }

    public void printAllActivities() {
        auditService.printActionsDetails("printAllActivities");
        printActivities(activityRepository.getActivities());
    }

    public void createNewActivity(String title, String weekday, int startingHour) {
        Activity activity = new Activity();
        activity.setTitle(title);
        activity.setWeekDay(weekday);
        activity.setStartingHour(startingHour);
        activityRepository.insertActivity(activity);
    }

    public List<ActivityDto> getAllActivities() {
        List<ActivityDto> resultedList  = new ArrayList<>();
        for (Activity a : activityRepository.getActivities()) {
            resultedList.add(new ActivityDto(a));
        }
        return resultedList;
    }

    public void updateActivity(String title, String weekday) {
        activityRepository.updateActivity(title, weekday);
    }

    public void deleteActivity(Activity activity) {
        activityRepository.deleteActivity(activity);
    }
}
