package main.java.hostel.controller.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import main.java.hostel.domain.entity.Employee;

public class EmployeeDto {
    public StringProperty cnp;
    public StringProperty name;
    public StringProperty originCountry;

    public EmployeeDto() {

    }

    public EmployeeDto(Employee employee) {
        if (employee == null) {
            return;
        }
        this.cnp = new SimpleStringProperty(employee.getCnp());
        this.name = new SimpleStringProperty(employee.getName());
    }

    public StringProperty cnpProperty() { return cnp; }

    public StringProperty nameProperty() { return name; }

}
