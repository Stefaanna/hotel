package main.java;

import main.java.hostel.services.HostelService;

public class Start {

    public static void main(String[] args) {

        HostelService hostelService = new HostelService();
        hostelService.start();
    }
}