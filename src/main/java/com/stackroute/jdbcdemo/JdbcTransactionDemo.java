package com.stackroute.jdbcdemo;

import java.sql.*;

public class JdbcTransactionDemo {
    public void transactionmanagementdemo() {
        //loading driver and regestering with DriverManager
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Use driverMtanager to get Connections
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123")) {
            Statement statement = connection.createStatement();
            //executing and updating the queries as single unit of processing
            statement.executeUpdate("insert into Employee values(03,'sraveena','f', 21)");
            statement.executeUpdate("insert into Employee values(43,'pravalika','f',22)");
            ResultSet resultSet = statement.executeQuery("Select * from Employee");
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name:" + resultSet.getString(2) +
                        " Gender:" + resultSet.getString(3) + " Age:" + resultSet.getInt(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}