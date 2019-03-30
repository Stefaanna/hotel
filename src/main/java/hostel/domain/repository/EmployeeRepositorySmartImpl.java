package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Employee;
import main.java.hostel.tool.EmployeeBuilder;
import main.java.hostel.tool.TestData;

public class EmployeeRepositorySmartImpl implements EmployeeRepository {

    private Employee[] employees;

    public EmployeeRepositorySmartImpl() {
        int length = TestData.getInstance().getEmployeeData().length;
        this.employees = new Employee[length];
        for (int i = 0; i < length; i++) {
            String[] splitedData = TestData.getInstance().getEmployeeData()[i].split(",");
            this.employees[i] =
                    new EmployeeBuilder()
                            .withName(splitedData[1] + " " + splitedData[2])
                            .withCnp(splitedData[0])
                            .build();

        }
    }

    @Override
    public Employee[] getEmployees() {
        return employees;
    }

}
