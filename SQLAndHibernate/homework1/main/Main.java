package homework1.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "ieroglif47";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT course_name, subscription_date," +
                    "count(course_name)/max(month(subscription_date)) " +
                    "FROM `purchaselist` WHERE year(subscription_date ) = 2018 group by course_name");

            while (resultSet.next()) {

                System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2)
                + " - " + resultSet.getString(3));

            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
