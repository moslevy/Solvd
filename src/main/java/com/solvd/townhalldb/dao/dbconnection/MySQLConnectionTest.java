package com.solvd.townhalldb.dao.dbconnection;

import java.sql.*;

public class MySQLConnectionTest {
    public static void main(String[] args) {

        var url = "jdbc:sqlserver://localhost:1433/townhalldb?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        try {

//          Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, "sa", "solvd1234");

            Statement statement = connection.createStatement();

            var sql = "SELECT id, county FROM TownHalls";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("id" + resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace(System.out);
        }
    }
}
