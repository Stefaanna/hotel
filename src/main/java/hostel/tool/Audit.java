package main.java.hostel.tool;

import java.io.*;
import java.sql.Timestamp;

public class Audit {

    public void printActionsDetails(String actionName) {

        try {
            FileWriter fileWriter = new FileWriter("D://Facultate//2.2//PAO//hostel//src//main//java//hostel//data//actions.csv", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            printWriter.print(actionName);
            printWriter.print(",");
            printWriter.println(timestamp);

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}