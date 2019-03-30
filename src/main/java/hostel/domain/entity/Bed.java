package main.java.hostel.domain.entity;

import java.util.Date;

public class Bed {
    private int bedNumber;
    private int roomNumber;
    private boolean available;
    private Date startDate;
    private Date endDate;

    public Bed() {
        this.available = true;
    }

    public Bed(int bedNumber) {
        this.bedNumber = bedNumber;
        this.available = false;
    }

    public void setAvailability() {
        this.available = !this.available;
    }

    public boolean getAvailability() {
        return this.available;
    }

    public int getBedNumber() {
        return this.bedNumber;
    }
}
