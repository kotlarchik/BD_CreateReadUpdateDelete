package ru.sapteh;

import java.sql.*;

public class Program {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection (
                "jdbc:mysql://localhost:3306/worlds?user=root&password=1111&serverTimezone=UTC")){

            String sql = "SELECT * FROM country";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                int id = result.getInt("id_country");
                String nameCountry = result.getString("nameCountry");
                int quantyCity = result.getInt("quantyCity");

                System.out.printf("%d \t%s \t%d\n", id, nameCountry, quantyCity);
            }
        }
    }
}