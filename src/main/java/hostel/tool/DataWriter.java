package main.java.hostel.tool;

import main.java.hostel.tool.ActivityGenerator;
import main.java.hostel.tool.EmployeeGenerator;
import main.java.hostel.tool.GuestGenerator;
import main.java.hostel.tool.VolunteerGenerator;

public class DataWriter {

    public void writeAllData() {

        // printing to files
        ActivityGenerator activityWriter = new ActivityGenerator();
        activityWriter.writeActivityData();
        EmployeeGenerator employeeWriter = new EmployeeGenerator();
        employeeWriter.writeEmployeeData();
        GuestGenerator guestWriter = new GuestGenerator();
        guestWriter.writeGuestData();
        VolunteerGenerator volunteerWriter = new VolunteerGenerator();
        volunteerWriter.writeVolunteerData();

    }
}
