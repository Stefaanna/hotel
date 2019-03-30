package main.java.hostel.domain.entity;

public class Room {
    private int roomNumber;
    private Bed[] beds;
    private int totalNumberOfBeds;

    public Room() {
        this.totalNumberOfBeds = 6;
    }

    public Room(Bed[] beds) {
        this.beds = beds;
        this.totalNumberOfBeds = 6;
    }

    public int getNumberOfBeds() {
        return totalNumberOfBeds;
    }

    public void getUnavailableBedsPerRoom() {
        for (int i = 0; i < beds.length; i++) {
            if (beds[i] == null) {
                System.out.println("--------------------------");
            } else {
                System.out.println("Bed number " + (beds[i].getBedNumber()+1));
            }
        }
    }

    public void getAvailableBedsPerRoom() {
        int checkedBed[] = new int[totalNumberOfBeds];
        for (int i = 0; i < totalNumberOfBeds; i++)
            checkedBed[i] = 0;
        for (int i = 0; i < beds.length; i++) {
            if (beds[i] == null) {
                System.out.println("--------------------------");
                break;
            } else {
                checkedBed[beds[i].getBedNumber()] = 1;
            }
        }
        for (int i = 0; i < totalNumberOfBeds; i++)
            if (checkedBed[i] == 0)
                System.out.println("Bed number " + (i+1));
    }
}
