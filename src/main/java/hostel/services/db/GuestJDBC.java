package main.java.hostel.services.db;

import main.java.hostel.domain.entity.Guest;
import main.java.hostel.services.AuditService;

import java.sql.*;

public class GuestJDBC {

    private static GuestJDBC instance = new GuestJDBC();

    public  static  GuestJDBC getInstance() { return instance; }

    private GuestJDBC() {}

    public void CreateGuest() {
        AuditService.getInstance().printActionsDetails("create GuestTable JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE `hotel`.`GuestJDBC` (\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `cnp` VARCHAR(15),\n" +
                    "  `originCountry` VARCHAR(45),\n" +
                    "  PRIMARY KEY (`name`));");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddGuest(Guest guest) {
        AuditService.getInstance().printActionsDetails("add Guest JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com = "INSERT INTO Guest(name, cnp, originCountry) values(?,?,?)";

            preparedStatement = connection.prepareStatement(com);
            preparedStatement.setString(1, guest.getName());
            preparedStatement.setString(2, guest.getCnp());
            preparedStatement.setString(3, guest.getOriginCountry());

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateGuest(String update, String name, String cnp, String originCountry) {
        AuditService.getInstance().printActionsDetails("update Guest JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com = "UPDATE Guest SET name = ?, cnp = ?, originCountry = ? WHERE name = ?";
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

    public void ReadGuest() {
        AuditService.getInstance().printActionsDetails("read Guest JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from Guest");

            while (resultSet.next()) {
                System.out.println("name=" + resultSet.getString(1)
                        + ", cnp=" + resultSet.getString(2)
                        + ", originCountry=" + resultSet.getString(3));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteGuest(String name) {
        AuditService.getInstance().printActionsDetails("delete Guest JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com= "DELETE from Guest WHERE name = ?";

            preparedStatement = connection.prepareStatement(com);

            preparedStatement.setString(1, name);

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
