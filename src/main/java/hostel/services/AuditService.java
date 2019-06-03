package main.java.hostel.services;

import java.io.*;
import java.sql.Timestamp;

public class AuditService {

    private static PrintWriter printWriter;
    private static AuditService instance = new AuditService();

    public static AuditService getInstance() { return instance; }

    private AuditService() {
        try {
            printWriter = new PrintWriter(new File("D:\\Facultate\\2.2\\PAO\\lab\\hotel\\src\\main\\java\\hostel\\data\\actions.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() { closeWriter(); }
        });
    }

    public void printActionsDetails(String actionName) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        printWriter.println(actionName + "," + timestamp + "," + Thread.currentThread());
    }

    private boolean closeWriter () {
        boolean result = true;
        printWriter.flush();
        printWriter.close();
        return result;
    }
}