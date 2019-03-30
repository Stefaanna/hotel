package main.java.hostel.domain.entity;

import java.util.Date;

public class Employee extends Person {

    private Date hireDate;

    public Employee(String cnp, String name) {
        super(cnp, name);
    }

    public Employee(String cnp, String name, Date hireDate) {
        super(cnp, name);
        this.setHireDate(hireDate);
    }

    public Employee() {
        super();
    }

    public Date getHireDate() { return hireDate; }

    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
}
