package main.java.hostel.tool;

import main.java.hostel.domain.entity.Employee;

import java.util.Date;

public class EmployeeBuilder {

    private final Employee target = new Employee();

    public EmployeeBuilder withName(String name) {
        target.setName(name);
        return this;
    }

    public EmployeeBuilder withCnp(String cnp) {
        target.setCnp(cnp);
        return this;
    }

    public EmployeeBuilder withHireDate(Date date) {
        target.setHireDate(date);
        return this;
    }



    public Employee build() { return target; }

}
