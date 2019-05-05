package main.java.hostel.services;

import java.io.*;
import java.sql.Timestamp;

public class AuditService {

    private static AuditService instance;

    public static AuditService getInstance() {
        if (instance == null) {
            instance = new AuditService();
        }
        return instance;
    }

    public void printActionsDetails(String actionName)  {

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
//            throw new HostelException(PRINT_AUDIT, e.getMessage());
        }
    }
}