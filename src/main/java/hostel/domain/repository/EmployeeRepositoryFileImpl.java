package main.java.hostel.domain.repository;

import main.java.hostel.domain.entity.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EmployeeRepositoryFileImpl implements EmployeeRepository {
    private Set<Employee> employees = new HashSet<Employee>();

    public EmployeeRepositoryFileImpl(String filename) throws FileNotFoundException {
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            Employee newEntry = new Employee(values[1], values[0]); // values[0] -> Name; values[1] -> CNP
            employees.add(newEntry);
        }
    }

    @Override
    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void insertEmployee(Employee employee) { employees.add(employee); }

    @Override
    public void updateEmployee(String cnp, String name) {
        // update the name of the employee
        Employee lastEmployee = null;
        for (Employee e : employees) {
            if (e.getCnp().equals(cnp)) {
                lastEmployee = e;
            }
        }
        lastEmployee.setName(name);
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }
}
