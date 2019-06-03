package main.java.hostel.services.db;


import main.java.hostel.domain.entity.Volunteer;
import main.java.hostel.services.AuditService;

import java.sql.*;

public class VolunteerJDBC {

    private static VolunteerJDBC instance = new VolunteerJDBC();

    public  static  VolunteerJDBC getInstance() { return instance; }

    private VolunteerJDBC() {}

    public void CreateVolunteer() {
        AuditService.getInstance().printActionsDetails("create VolunteerTable JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE `hotel`.`Volunteer` (\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `cnp` VARCHAR(15),\n" +
                    "  `originCountry` VARCHAR(45),\n" +
                    "  PRIMARY KEY (`name`));");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddVolunteer(Volunteer volunteer) {
        AuditService.getInstance().printActionsDetails("add volunteer JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com = "INSERT INTO Volunteer(name, cnp, originCountry) values(?,?,?)";

            preparedStatement = connection.prepareStatement(com);
            preparedStatement.setString(1, volunteer.getName());
            preparedStatement.setString(2, volunteer.getCnp());
            preparedStatement.setString(3, volunteer.getOriginCountry());

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateVolunteer(String update, String name, String cnp, String originCountry) {
        AuditService.getInstance().printActionsDetails("update Volunteer JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com = "UPDATE Volunteer SET name = ?, cnp = ?, originCountry = ? WHERE name = ?";
            preparedStatement = connection.prepareStatement(com);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, cnp);
            preparedStatement.setString(3, originCountry);
            preparedStatement.setString(4, update);

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void ReadVolunteer() {
        AuditService.getInstance().printActionsDetails("read Volunteer JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from Volunteer");

            while (resultSet.next()) {
                System.out.println("name=" + resultSet.getString(1)
                        + ", cnp=" + resultSet.getString(2)
                        + ", originCountry=" + resultSet.getString(3));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteVolunteer(String name) {
        AuditService.getInstance().printActionsDetails("delete Volunteer JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com= "DELETE from Volunteer WHERE name = ?";

            preparedStatement = connection.prepareStatement(com);

            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
