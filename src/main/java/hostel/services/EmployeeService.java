package main.java.hostel.services;

import main.java.hostel.configuration.RepositoryConfig;
import main.java.hostel.domain.entity.Employee;
import main.java.hostel.domain.repository.EmployeeRepository;

import java.util.Set;

public class EmployeeService {

    private EmployeeRepository employeeRepository = RepositoryConfig.getInstance().getEmployeeRepository();

    public EmployeeService() {}

    public String[] searchEmployeesByASpecificPattern(String partialUserName) {
        Set<Employee> employeesInHostelService = employeeRepository.getEmployees();
        String[] result = new String[employeesInHostelService.size()];
        int counter = 0;
        String pattern = createPattern(partialUserName);
        for (Employee e : employeesInHostelService) {
            if (e != null && e.getName().matches(pattern)) {
                result[counter++] = e.getName();
            }
        }
        return result;
    }

    private String createPattern(String partialUserName) {
        String[] splitedPartialName = partialUserName.split("(?=[A-Z])");
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < splitedPartialName.length; i++) {
            resultBuilder.append(splitedPartialName[i]);
            resultBuilder.append("[a-z]*"); //append any number of lower case characters

            resultBuilder.append("[[A-z]{1}[a-z]+\\s]*"); //any number of other names
            if (!(i == splitedPartialName.length - 1)) { //if it's not the last part
                resultBuilder.append("\\s"); //append one space
            }
        }
        return resultBuilder.toString();
    }

    private void printEmployees(Set<Employee> result) {
        for (Employee e : result) {
            System.out.println(/*e.getCnp() + " " + */e.getName());
        }
    }

    public void printAllEmployees() { printEmployees(employeeRepository.getEmployees()); }

}
