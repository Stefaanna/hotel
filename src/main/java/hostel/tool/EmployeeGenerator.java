package main.java.hostel.tool;

import main.java.hostel.domain.entity.Employee;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class EmployeeGenerator {

    public static void writeEmployeeData() {

        try {
            FileWriter fileWriter = new FileWriter("D://Facultate//2.2//PAO//hostel//src//main//java//hostel//tool//data//employees.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            Set<Employee> employees = new HashSet<Employee>();

            employees.add(new EmployeeBuilder().withName("Stacey Winford").withCnp("146250905").build());
            employees.add(new EmployeeBuilder().withName("Stellian Forschbitz").withCnp("23450905").build());
            employees.add(new EmployeeBuilder().withName("Hannie McMillow").withCnp("868135230").build());
            employees.add(new EmployeeBuilder().withName("Francesco Emero").withCnp("157477360").build());
            employees.add(new EmployeeBuilder().withName("Dona Portman").withCnp("457412343").build());

            for (Employee employee : employees) {
                printWriter.print(employee.getName());
                printWriter.print(",");
                printWriter.print(employee.getCnp());
                printWriter.println();
            }

            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
