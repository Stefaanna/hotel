package main.java.hostel.configuration;

import main.java.hostel.domain.repository.*;

public class RepositoryConfig {

//    private final EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    private final EmployeeRepository employeeRepository = new EmployeeRepositorySmartImpl();
    private final VolunteerRepository volunteerRepository = new VolunteerRepositorySmartImpl();
    private final GuestRepository guestRepository  = new GuestRepositorySmartImpl();
    private final ActivityRepository activityRepository = new ActivityRepositoryImpl();

    public EmployeeRepository getEmployeeRepository() { return  employeeRepository; }
    public VolunteerRepository getVolunteerRepository() { return volunteerRepository; }
    public GuestRepository getGuestRepository() { return guestRepository; }


    private static RepositoryConfig ourInstance = new RepositoryConfig();
    public static RepositoryConfig getInstance() {
        return ourInstance;
    }

    private RepositoryConfig() {}

    public ActivityRepository getActivitiesRepository() { return activityRepository; }
}
