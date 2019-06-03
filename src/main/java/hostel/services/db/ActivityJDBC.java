package main.java.hostel.services.db;

import main.java.hostel.domain.entity.Activity;
import main.java.hostel.services.AuditService;

import java.sql.*;

public class ActivityJDBC {

    private static ActivityJDBC instance = new ActivityJDBC();

    public  static  ActivityJDBC getInstance() { return instance; }

    private ActivityJDBC() {}

    public void CreateActivity() {
        AuditService.getInstance().printActionsDetails("create ActivityTable JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE `hotel`.`Activity` (\n" +
                    "  `title` VARCHAR(45) NOT NULL,\n" +
                    "  `weekday` VARCHAR(10),\n" +
                    "  `startingHour` INTEGER(3),\n" +
                    "  PRIMARY KEY (`title`));");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddActivity(Activity activity) {
        AuditService.getInstance().printActionsDetails("add activity JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com = "INSERT INTO Activity(title, weekday, startingHour) values(?,?,?)";

            preparedStatement = connection.prepareStatement(com);
            preparedStatement.setString(1, activity.getTitle());
            preparedStatement.setString(2, activity.getWeekDay());
            preparedStatement.setInt(3, activity.getStartingHour());

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateActivity(String update, String title, String weekday, int startingHour) {
        AuditService.getInstance().printActionsDetails("update Activity JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com = "UPDATE Activity SET title = ?, weekday = ?, startingHour = ? WHERE title = ?";
            preparedStatement = connection.prepareStatement(com);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, weekday);
            preparedStatement.setInt(3, startingHour);
            preparedStatement.setString(4, update);

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void ReadActivity() {
        AuditService.getInstance().printActionsDetails("read Activity JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from Activity");

            while (resultSet.next()) {
                System.out.println("title=" + resultSet.getString(1)
                        + ", weekday=" + resultSet.getString(2)
                        + ", startingHour=" + resultSet.getInt(3));
            }



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteActivity(String title) {
        AuditService.getInstance().printActionsDetails("delete Activity JDBC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String com= "DELETE from Activity WHERE title = ?";

            preparedStatement = connection.prepareStatement(com);

            preparedStatement.setString(1, title);

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
