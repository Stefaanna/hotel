package main.java.hostel.services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import main.java.hostel.configuration.RepositoryConfig;
import main.java.hostel.domain.entity.Guest;
import main.java.hostel.domain.repository.GuestRepository;

public class GuestService {

    private GuestRepository guestRepository = RepositoryConfig.getInstance().getGuestRepository();

    public GuestService() {}

    private void printGuests(Guest[] result) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] == null) {
                System.out.println("--------------------------");
                break;
            }
            System.out.println(/*result[i].getCnp() + " " + */result[i].getName() + " from " + result[i].getOriginCountry()/* + " with the CNP " + result[i].getCnp()*/);
        }
    }

    public void printAllGuests() { printGuests(guestRepository.getGuests()); }

    public void searchGuestByCnp(String cnp) {
        Guest[] guests = guestRepository.getGuests();
        Boolean found = false;
        for (int i=0; i< guests.length; i++) {
            if (guests[i] == null) {
                System.out.println("There is no guest with the CNP " + cnp);
                break;
            }
            else {
                if (guests[i].getCnp().equals(cnp)) {
                    System.out.println("The guest with the CNP " + cnp + " is " + guests[i].getName());
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.println("There is no guest with the CNP " + cnp);
    }

    public void searchGuestByOriginCountry(String country) {
        Guest[] guests = guestRepository.getGuests();
        Boolean found = false;
        System.out.println("\nGuests from " + country + ":");
        for (int i=0; i< guests.length; i++) {
            if (guests[i] == null) {
                System.out.println("There is no guest from " + country);
                break;
            }
            else {
                if (guests[i].getOriginCountry().equals(country)) {
                    System.out.println(guests[i].getName());
                    found = true;
                }
            }
        }
        if (!found) System.out.println("There is no guest from " + country);
    }
}
