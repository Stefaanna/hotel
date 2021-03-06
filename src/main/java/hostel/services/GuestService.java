package main.java.hostel.services;

import main.java.hostel.configuration.RepositoryConfig;
import main.java.hostel.controller.dto.GuestDto;
import main.java.hostel.domain.entity.Guest;
import main.java.hostel.domain.repository.GuestRepository;

import java.util.ArrayList;
import java.util.List;

public class GuestService {

    private GuestRepository guestRepository = RepositoryConfig.getInstance().getGuestRepository();
    private AuditService auditService = AuditService.getInstance();

    public GuestService() {
    }

    private void printGuests(ArrayList<Guest> result) {
        for (Guest g : result) {
            System.out.println(g.getName() + " from " + g.getOriginCountry());
        }
    }

    public void printAllGuests() {
        auditService.printActionsDetails("printAllGuests");
        printGuests(guestRepository.getGuests());
    }

    public void searchGuestByCnp(String cnp) {
        auditService.printActionsDetails("searchGuestByCnp");
        ArrayList<Guest> guests = guestRepository.getGuests();
        Boolean found = false;
        for (Guest g : guests) {
            if (g == null) {
                System.out.println("There is no guest with the CNP " + cnp);
                break;
            } else {
                if (g.getCnp().equals(cnp)) {
                    System.out.println("The guest with the CNP " + cnp + " is " + g.getName());
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.println("There is no guest with the CNP " + cnp);
    }

    public void searchGuestByOriginCountry(String country) {
        auditService.printActionsDetails("searchGuestByOriginCountry");
        ArrayList<Guest> guests = guestRepository.getGuests();
        Boolean found = false;
        System.out.println("\nGuests from " + country + ":");
        for (Guest g : guests) {
            if (g == null) {
                System.out.println("There is no guest from " + country);
                break;
            } else {
                if (g.getOriginCountry().equals(country)) {
                    System.out.println(g.getName());
                    found = true;
                }
            }
        }
        if (!found) System.out.println("There is no guest from " + country);
    }

    public void createNewGuest(String cnp, String name, String originCountry) {
        Guest guest = new Guest();
        guest.setCnp(cnp);
        guest.setName(name);
        guest.setOriginCountry(originCountry);
        guestRepository.insertGuest(guest);
    }

    public List<GuestDto> getAllGuests() {
        List<GuestDto> resultedList  = new ArrayList<>();
        for (Guest g : guestRepository.getGuests()) {
            resultedList.add(new GuestDto(g));
        }
        return resultedList;
    }

    public void updateGuest(String cnp, String name, String originCountry) {
        guestRepository.updateGuest(cnp, name, originCountry);
    }

    public void deleteGuest(Guest guest) {
        guestRepository.deleteGuest(guest);
    }

    public List<Guest> getGuests() {
        List<Guest> resultedList  = new ArrayList<>();
        for (Guest g : guestRepository.getGuests()) {
            resultedList.add(new Guest(g));
        }
        return resultedList;
    }

    public List<Guest> searchGuestsByCountry() {
        auditService.printActionsDetails("searchGuestByOriginCountry");
        ArrayList<Guest> guests = guestRepository.getGuests();
        List<Guest> result = new ArrayList<>();
        String country = "Portugal";
        for (Guest g : guests) {
            if (g == null) {
                break;
            } else {
                if (g.getOriginCountry().equals(country)) {
                    result.add(g);
                }
            }
        }
        return result;
    }

    public List<Guest> searchGuestsByCnp() {
        auditService.printActionsDetails("searchGuestByCnp");
        ArrayList<Guest> guests = guestRepository.getGuests();
        String cnp="43782223";
        List<Guest> result = new ArrayList<>();
        for (Guest g : guests) {
            if (g == null) {
                break;
            } else {
                if (g.getCnp().equals(cnp)) {
                    result.add(g);
                }
            }
        }
        return result;
    }
}
