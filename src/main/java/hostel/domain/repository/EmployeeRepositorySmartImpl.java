package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Employee;
import main.java.hostel.tool.EmployeeBuilder;
import main.java.hostel.tool.TestData;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositorySmartImpl implements EmployeeRepository {

    //    private Employee[] employees;
    private Set<Employee> employees = new HashSet<Employee>();

    public EmployeeRepositorySmartImpl() {
        int length = TestData.getInstance().getEmployeeData().length;
//        this.employees = new Employee[length];
        for (int i = 0; i < length; i++) {
            String[] splitedData = TestData.getInstance().getEmployeeData()[i].split(",");
            this.employees.add(
                    new EmployeeBuilder()
                            .withName(splitedData[1] + " " + splitedData[2])
                            .withCnp(splitedData[0])
                            .build());

        }
    }

    @Override
//    public Employee[] getEmployees() {
//        return employees;
//    }
    public Set<Employee> getEmployees() {
        return employees;
    }
}
