package main.java.hostel.services;

import main.java.hostel.configuration.RepositoryConfig;
import main.java.hostel.domain.entity.Guest;
import main.java.hostel.domain.repository.ActivityRepository;
import main.java.hostel.domain.repository.ReservationRepository;
import main.java.hostel.domain.repository.ReservationRepositoryImpl;
import main.java.hostel.domain.repository.RoomsRepository;
import main.java.hostel.tool.DataWriter;

import java.util.Date;
import java.util.Scanner;

public class HostelService {

    public void start() {

        System.out.println("Welcome to the Backpacker's Hostel!\n");

        // printing to files
        DataWriter writer = new DataWriter();
        writer.writeAllData();

        System.out.println("-------------------------\n" +
                "Choose an operation:\n" +
                "0. Exit\n" +
                "1. printAllEmployees\n" +
                "2. printAllVolunteers\n" +
                "3. searchEmployeesByASpecificPattern\n" +
                "4. printAllGuests\n" +
                "5. searchGuestByCnp\n" +
                "6. searchGuestByOriginCountry\n" +
                "7. addActivity\n" +
                "8. printAllActivities\n" +
                "9. listAvailableBeds\n" +
                "10. addReservation");

        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();


        EmployeeService employeeService;
        GuestService guestService;
        VolunteerService volunteerService;
        ActivityService activityService;
        RoomsRepository roomsRepository;
//        ActivityRepository activityRepository;
        ReservationRepository reservationRepository;

        while (operation != 0) {
            switch (operation) {
                case 1:
                    //printAllEmployees
                    employeeService = new EmployeeService();
                    System.out.println("\nOur current employees are: ");
                    employeeService.printAllEmployees();
                    break;
                case 2:
                    //printAllVolunteers
                    volunteerService = new VolunteerService();
                    System.out.println("\nOur current volunteers are: ");
                    volunteerService.printAllVolunteers();
                    break;
                case 3:
                    //searchEmployeesByASpecificPattern
                    employeeService = new EmployeeService();
                    String[] partialName = {"StF", "HaCl", "StP"};
                    System.out.print("\nTrying to search in our hostel all employees that match the partial name: ");
                    for (int i = 0; i < partialName.length; i++) {
                        System.out.print(partialName[i] + " ");
                    }
                    System.out.println();
                    for (int i = 0; i < partialName.length; i++) {
                        String[] result = employeeService.searchEmployeesByASpecificPattern(partialName[i]);

                        for (int counter = 0; counter < result.length; counter++) {
                            if (result[counter] == null) {
                                break;
                            }
                            System.out.println(result[counter]);
                        }
                    }
                    break;
                case 4:
                    //printAllGuests
                    guestService = new GuestService();
                    System.out.println("\nOur current guests are: ");
                    guestService.printAllGuests();
                    System.out.println();
                case 5:
                    //searchGuestByCnp
                    guestService = new GuestService();
                    guestService.searchGuestByCnp("929202627");
                    guestService.searchGuestByCnp("123456780");
                    break;
                case 6:
                    //searchGuestByOriginCountry
                    guestService = new GuestService();
                    guestService.searchGuestByOriginCountry("Italy");
                    guestService.searchGuestByOriginCountry("Romania");
                    break;
                case 7:
                    //addActivity
//                    activityService = RepositoryConfig.getInstance().getActivityRepository();
                    activityService = new ActivityService();
                    activityService.addActivity("painting", "sunday", 18);
//                    activityRepository.addActivity("yoga", "sunday", 11);
//                    activityRepository.addActivity("running", "wednesday", 17);
                    break;
                case 8:
                    //printAllActivities
                    System.out.println("\nAt our hostel we usually do these activities: ");
                    activityService = new ActivityService();
                    activityService.printAllActivities();
                    break;
                case 9:
                    //listAvailableBeds
                    roomsRepository = new RoomsRepository();
                    roomsRepository.listAvailableBeds();
                    break;
                case 10:
                    //addReservation
                    Date comingDate = new Date(2019, 03, 30);
                    Date leavingDate = new Date(2019, 04, 04);

                    Guest guest = new Guest("Olivia", "1234567893", "France", comingDate, leavingDate);
                    reservationRepository = new ReservationRepositoryImpl();
                    reservationRepository.addReservation(guest);
                    break;
                default:
                    break;
                    
            }
            System.out.println("-------------------------\n" +
                    "Choose an operation:\n" +
                    "0. Exit\n" +
                    "1. printAllEmployees\n" +
                    "2. printAllVolunteers\n" +
                    "3. searchEmployeesByASpecificPattern\n" +
                    "4. printAllGuests\n" +
                    "5. searchGuestByCnp\n" +
                    "6. searchGuestByOriginCountry\n" +
                    "7. addActivity\n" +
                    "8. printAllActivities\n" +
                    "9. listAvailableBeds\n" +
                    "10. addReservation");
            operation = scanner.nextInt();
        }
    }
}
