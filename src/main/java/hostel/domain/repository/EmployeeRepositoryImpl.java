package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Employee;
import main.java.hostel.tool.EmployeeBuilder;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Employee[] employees =
            new Employee[] {
                    new EmployeeBuilder()
                            .withName("Employee1")
                            .withCnp("1234567891230")
                            .build(),
                    new EmployeeBuilder()
                            .withName("Employee2")
                            .withCnp("1234567891240")
                            .build(),
            };

    @Override
    public Employee[] getEmployees() { return employees; }


}
