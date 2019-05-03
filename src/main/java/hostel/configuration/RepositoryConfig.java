package main.java.hostel.configuration;

import main.java.hostel.domain.repository.*;

import java.io.FileNotFoundException;

public class RepositoryConfig {

    private EmployeeRepository employeeRepository;
    private VolunteerRepository volunteerRepository;
    private GuestRepository guestRepository;
    private ActivityRepository activityRepository;

    public EmployeeRepository getEmployeeRepository() { return  employeeRepository; }
    public VolunteerRepository getVolunteerRepository() { return volunteerRepository; }
    public GuestRepository getGuestRepository() { return guestRepository; }
    public ActivityRepository getActivityRepository() { return activityRepository; }


    private static RepositoryConfig ourInstance = new RepositoryConfig();
    public static RepositoryConfig getInstance() {
        return ourInstance;
    }

    private RepositoryConfig() {
        try {
            employeeRepository = new EmployeeRepositoryFileImpl("D:\\Facultate\\2.2\\PAO\\hostel\\src\\main\\java\\hostel\\data\\employees.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Could not create EmployeeRepositoryFileImpl: " + e.getMessage());
            System.out.println("The system will use the mock data from EmployeeRepositorySmartImpl");
            employeeRepository = new EmployeeRepositorySmartImpl();
        }

        try {
            volunteerRepository = new VolunteerRepositoryFileImpl("D:\\Facultate\\2.2\\PAO\\hostel\\src\\main\\java\\hostel\\data\\volunteers.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Could not create VolunteerRepositoryFileImpl: " + e.getMessage());
            System.out.println("The system will use the mock data from VolunteerRepositorySmartImpl");
            volunteerRepository = new VolunteerRepositorySmartImpl();
        }

        try {
            guestRepository = new GuestRepositoryFileImpl("D:\\Facultate\\2.2\\PAO\\hostel\\src\\main\\java\\hostel\\data\\guests.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Could not create GuestRepositoryFileImpl: " + e.getMessage());
            System.out.println("The system will use the mock data from GuestRepositorySmartImpl");
            guestRepository = new GuestRepositorySmartImpl();
        }

        try {
            activityRepository = new ActivityRepositoryFileImpl("D:\\Facultate\\2.2\\PAO\\hostel\\src\\main\\java\\hostel\\data\\activities.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Could not create ActivityRepositoryFileImpl: " + e.getMessage());
            System.out.println("The system will use the mock data from ActivityRepositoryImpl");
            activityRepository = new ActivityRepositoryImpl();
        }

    }

}
