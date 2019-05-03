package main.java.hostel.tool;

import main.java.hostel.domain.entity.Guest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GuestGenerator {

    public static void writeGuestData() {

        try {
            FileWriter fileWriter = new FileWriter("D://Facultate//2.2//PAO//hostel//src//main//java//hostel//data//guests.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            ArrayList<Guest> guests = new ArrayList<Guest>();

            guests.add(new GuestBuilder().withName("Stacey Varnouff").withCnp("12387164").withOriginCountry("Uruguay").build());
            guests.add(new GuestBuilder().withName("Constance Merill").withCnp("43782223").withOriginCountry("Romania").build());
            guests.add(new GuestBuilder().withName("Vivian Miller").withCnp("8715432").withOriginCountry("Portugal").build());
            guests.add(new GuestBuilder().withName("Virginia Robbins").withCnp("123456780").withOriginCountry("New Zeeland").build());

            for (Guest guest : guests) {
                printWriter.print(guest.getName());
                printWriter.print(",");
                printWriter.print(guest.getCnp());
                printWriter.print(",");
                printWriter.print(guest.getOriginCountry());
                printWriter.println();
            }

            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
