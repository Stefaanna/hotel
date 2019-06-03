package main.java.hostel.services.db;

import main.java.hostel.domain.entity.Employee;
import main.java.hostel.services.AuditService;

import java.sql.*;

public class EmployeeJDBC {

    private static EmployeeJDBC instance = new EmployeeJDBC();

    public  static  EmployeeJDBC getInstance() { return instance; }

    private EmployeeJDBC() {}

    public void CreateEmployee() {
        AuditService.getInstance().printActionsDetails("create EmployeeTable JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE `hotel`.`EmployeeJDBC` (\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `cnp` VARCHAR(15),\n" +
                    "  PRIMARY KEY (`name`));");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddEmployee(Employee employee) {
        AuditService.getInstance().printActionsDetails("add Employee JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com = "INSERT INTO Employee(name, cnp) values(?,?)";

            preparedStatement = connection.prepareStatement(com);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getCnp());

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateEmployee(String update, String name, String cnp) {
        AuditService.getInstance().printActionsDetails("update Employee JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com = "UPDATE Employee SET name = ?, cnp = ? WHERE name = ?";
            preparedStatement = connection.prepareStatement(com);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, cnp);
            preparedStatement.setString(3, update);

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void ReadGEmployee() {
        AuditService.getInstance().printActionsDetails("read Employee JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from Employee");

            while (resultSet.next()) {
                System.out.println("name=" + resultSet.getString(1)
                        + ", cnp=" + resultSet.getString(2));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteEmployee(String name) {
        AuditService.getInstance().printActionsDetails("delete Employee JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com= "DELETE from Employee WHERE name = ?";

            preparedStatement = connection.prepareStatement(com);

            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
