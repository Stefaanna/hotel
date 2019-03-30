package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Bed;
import main.java.hostel.domain.entity.Room;

public class RoomsRepository {

    Bed[] beds1 = new Bed[] {
            new Bed(1), new Bed(2), new Bed(4)
    };
    Bed[] beds2 = new Bed[] {
            new Bed(0), new Bed(4), new Bed(5)
    };
    Bed[] beds3 = new Bed[] {
            new Bed(1), new Bed(3), new Bed(4)
    };
    Bed[] beds4 = new Bed[] {
            new Bed(0), new Bed(2)
    };

    Room[] rooms = new Room[]{
        new Room(beds1), new Room(beds2), new Room(beds3), new Room(beds4)
    };

    public Room[] getRooms() {
        return rooms;
    }



    public void listUnavailableBeds() {
        System.out.println("The occupied beds that we have are: ");
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {
                System.out.println("-------------------------------");
            }
            else {
                System.out.println("From dorm number " + (i+1) + ":");
                rooms[i].getUnavailableBedsPerRoom();
            }

        }
    }

    public void listAvailableBeds() {
        System.out.println("The available beds that we have are: ");
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {
                System.out.println("-------------------------------");
            }
            else {
                System.out.println("From dorm number " + (i+1) + ":");
                rooms[i].getAvailableBedsPerRoom();
            }

        }
    }
}
