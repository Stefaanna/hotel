package main.java.hostel.domain.entity;

import java.util.Date;

public class Volunteer extends Person {

    private Date hireDate;
    private Date leavingDate;
    private String originCountry;

    public Volunteer() {
        super();
    }

    public Volunteer(String cnp, String name) {
        super(cnp, name);
    }

    public Volunteer(String cnp, String name, String originCountry) {
        super(cnp, name);
        this.setOriginCountry(originCountry);
    }

    public Volunteer(String cnp, String name, Date hireDate, Date leavingDate, String originCountry) {
        super(cnp, name);
        this.setHireDate(hireDate);
        this.setLeavingDate(leavingDate);
        this.setOriginCountry(originCountry);
    }

    public Date getHireDate() { return hireDate; }

    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    public Date getLeavingDate() { return leavingDate; }

    public void setLeavingDate(Date leavingDate) { this.leavingDate = leavingDate;}

    public String getOriginCountry() { return originCountry; }

    public void setOriginCountry(String originCountry) { this.originCountry = originCountry; }

}
