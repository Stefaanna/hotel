package main.java.hostel.domain.entity;

import java.util.Date;

public class Guest extends Person {

    private Date comingDate;
    private Date leavingDate;
    private String originCountry;
    private String adress;
    private String reservationNumber;
    private String email;
    private String gender;

    public Guest() {}

    public Guest(String name, String cnp, String originCountry, Date comingDate, Date leavingDate) {
        super(name, cnp);
        this.setOriginCountry(originCountry);
        this.setComingDate(comingDate);
        this.setLeavingDate(leavingDate);
    }

    public Guest(String name, String cnp, String originCountry) {
        super(name, cnp);
        this.setOriginCountry(originCountry);
    }

    public void setComingDate(Date date) {
        this.comingDate = comingDate;
    }

    public Date getComingDate() {
        return comingDate;
    }

    public void setLeavingDate(Date date) {
        this.leavingDate = leavingDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
