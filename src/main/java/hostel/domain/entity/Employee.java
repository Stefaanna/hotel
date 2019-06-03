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

    public Employee(Employee e) {
        this.setCnp(e.getCnp());
        this.setName(e.getName());
    }

    public Employee(String name) {
        this.setName(name);
    }

    public Date getHireDate() { return hireDate; }

    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
}
