package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Employee;

import java.util.Set;

public interface EmployeeRepository {

//    public Employee[] getEmployees();
    public Set<Employee> getEmployees();

    void insertEmployee(Employee employee);

    void updateEmployee(String cnp, String name);

    void deleteEmployee(Employee employee);
}
