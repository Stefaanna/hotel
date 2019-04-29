package main.java;

import main.java.hostel.configuration.RepositoryConfig;
import main.java.hostel.domain.entity.Guest;
import main.java.hostel.domain.repository.*;
import main.java.hostel.services.EmployeeService;
import main.java.hostel.services.GuestService;
import main.java.hostel.services.VolunteerService;
import main.java.hostel.tool.data.DataWriter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;


public class Start {

    public static void main(String[] args) {

        /*System.out.println("Welcome to the Backpacker's Hostel!\n");

        // printing to files
        DataWriter writer = new DataWriter();
        writer.writeAllData();

        //printAllEmployees
        EmployeeService employeeService = new EmployeeService();
        System.out.println("\nOur current employees are: ");
        employeeService.printAllEmployees();

        //printAllVolunteers
        VolunteerService volunteerService = new VolunteerService();
        System.out.println("\nOur current volunteers are: ");
        volunteerService.printAllVolunteers();

        //searchEmployeesByASpecificPattern
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

        //printAllGuests
        GuestService guestService = new GuestService();
        System.out.println("\nOur current guests are: ");
        guestService.printAllGuests();
        System.out.println();

        //searchGuestByCnp
        guestService.searchGuestByCnp("929202627");
        guestService.searchGuestByCnp("123456780");

        //searchGuestByOriginCountry
        guestService.searchGuestByOriginCountry("Italy");
        guestService.searchGuestByOriginCountry("Romania");

        //addActivity
        ActivityRepository activityRepository = RepositoryConfig.getInstance().getActivityRepository();
        activityRepository.addActivity("painting","sunday",18);
        activityRepository.addActivity("yoga","sunday",11);
        activityRepository.addActivity("running","wednesday",17);

        //printAllActivities
//        ActivityRepository activityRepository = RepositoryConfig.getInstance().getActivityRepository();
        System.out.println("\nAt our hostel we usually do these activities: ");
        activityRepository.printAllActivities();

        //listUnavailableBeds
        RoomsRepository roomsRepository = new RoomsRepository();
        //roomsRepository.listUnavailableBeds();

        //listAvailableBeds
        roomsRepository.listAvailableBeds();

        //addReservation
        *//*SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
        String date1 = "30/03/2019";
        String date2 = "04/04/2019";
        Date comingDate = new Date();
        Date leavingDate = new Date();
        try {
            comingDate = formatter.parse(date1);
            leavingDate = formatter.parse(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }*//*
        //SAU
        Date comingDate = new Date(2019,03,30);
        Date leavingDate = new Date(2019,04,04);

        Guest guest = new Guest("Olivia","1234567893","France", comingDate, leavingDate);
        ReservationRepository reservationRepository = new ReservationRepositoryImpl();
        reservationRepository.addReservation(guest);
*/

        Start start = new Start();
        start.start();

    }

    public void start() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        System.out.println("Welcome to the Backpacker's Hostel!\n");

        // printing to files
        DataWriter writer = new DataWriter();
        writer.writeAllData();

        System.out.println("Choose an operation:\n" +
                "0. Exit\n" +
                "1. printAllEmployees\n" +
                "2. printAllVolunteers\n" +
                "3. printAllGuests\n" +
                "4. searchGuestByCnp\n" +
                "5. searchGuestByOriginCountry\n" +
                "6. printAllActivities\n" +
                "7. addActivity\n" +
                "8. addReservation\n" +
                "9. searchEmployeeByASpecificPattern\n" +
                "10. listAvailableBeds");

        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();


        EmployeeService employeeService;
        GuestService guestService;
        VolunteerService volunteerService;
        RoomsRepository roomsRepository;
        ActivityRepository activityRepository;
        ReservationRepository reservationRepository;

        while (operation!=0) {
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
                    activityRepository = RepositoryConfig.getInstance().getActivityRepository();
                    activityRepository.addActivity("painting","sunday",18);
                    activityRepository.addActivity("yoga","sunday",11);
                    activityRepository.addActivity("running","wednesday",17);
                    break;
                case 8:
                    //printAllActivities
                    activityRepository = RepositoryConfig.getInstance().getActivityRepository();
                    System.out.println("\nAt our hostel we usually do these activities: ");
                    activityRepository.printAllActivities();
                    break;
                case 9:
                    //listAvailableBeds
                    roomsRepository = new RoomsRepository();
                    roomsRepository.listAvailableBeds();
                    break;
                case 10:
                    //addReservation
                    Date comingDate = new Date(2019,03,30);
                    Date leavingDate = new Date(2019,04,04);

                    Guest guest = new Guest("Olivia","1234567893","France", comingDate, leavingDate);
                    reservationRepository = new ReservationRepositoryImpl();
                    reservationRepository.addReservation(guest);
                    break;
                default:
                    break;

            }
            System.out.println("Choose an operation:\n" +
                    "0. Exit\n" +
                    "1. printAllEmployees\n" +
                    "2. printAllVolunteers\n" +
                    "3. printAllGuests\n" +
                    "4. searchGuestByCnp\n" +
                    "5. searchGuestByOriginCountry\n" +
                    "6. printAllActivities\n" +
                    "7. addActivity\n" +
                    "8. addReservation\n" +
                    "9. searchEmployeeByASpecificPattern\n" +
                    "10. listAvailableBeds");
            operation = scanner.nextInt();
        }

    }
}
