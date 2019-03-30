package main.java;

import main.java.hostel.domain.entity.Guest;
import main.java.hostel.domain.repository.*;
import main.java.hostel.services.EmployeeService;
import main.java.hostel.services.GuestService;
import main.java.hostel.services.VolunteerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Start {

    public static void main(String[] args) {

        System.out.println("Welcome to the Backpacker's Hostel!\n");

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

        //searchGuestByCnp
        guestService.searchGuestByCnp("929202627");
        guestService.searchGuestByCnp("123456780");

        //searchGuestByOriginCountry
        guestService.searchGuestByOriginCountry("Italy");
        guestService.searchGuestByOriginCountry("Romania");

        //addActivity
        ActivityRepository activityRepository = new ActivityRepositoryImpl();
        activityRepository.addActivity("painting","sunday",18);
        activityRepository.addActivity("yoga","sunday",11);
        activityRepository.addActivity("running","wednesday",17);

        //printAllActivities
        System.out.println("\nAt our hostel we usually do these activities: ");
        activityRepository.printAllActivities();

        //listUnavailableBeds
        RoomsRepository roomsRepository = new RoomsRepository();
//        roomsRepository.listUnavailableBeds();

        //listAvailableBeds
        roomsRepository.listAvailableBeds();

        //addReservation
        /*SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YYYY");
        String date1 = "30/03/2019";
        String date2 = "04/04/2019";
        Date comingDate = new Date();
        Date leavingDate = new Date();
        try {
            comingDate = formatter.parse(date1);
            leavingDate = formatter.parse(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        //SAU
        Date comingDate = new Date(2019,03,30);
        Date leavingDate = new Date(2019,04,04);

        Guest guest = new Guest("Olivia","1234567893","France", comingDate, leavingDate);
        ReservationRepository reservationRepository = new ReservationRepositoryImpl();
        reservationRepository.addReservation(guest);



    }
}
