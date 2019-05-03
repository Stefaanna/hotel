package main.java.hostel.tool;

import main.java.hostel.domain.entity.Volunteer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class VolunteerGenerator {

    public static void writeVolunteerData() {

        try {
            FileWriter fileWriter = new FileWriter("D://Facultate//2.2//PAO//hostel//src//main//java//hostel//data//volunteers.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            Set<Volunteer> volunteers = new HashSet<Volunteer>();

            volunteers.add(new VolunteerBuilder().withName("Tolland Ramone").withCnp("3527811").withOriginCountry("Brazil").build());
            volunteers.add(new VolunteerBuilder().withName("Asaf Nolafh").withCnp("47521141").withOriginCountry("Israel").build());
            volunteers.add(new VolunteerBuilder().withName("Igen Vilalh").withCnp("18756479").withOriginCountry("Israel").build());
            volunteers.add(new VolunteerBuilder().withName("Diego Hernama").withCnp("87418913").withOriginCountry("Guatemala").build());


            for (Volunteer volunteer : volunteers) {
                printWriter.print(volunteer.getName());
                printWriter.print(",");
                printWriter.print(volunteer.getCnp());
                printWriter.print(",");
                printWriter.print(volunteer.getOriginCountry());
                printWriter.println();
            }

            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
