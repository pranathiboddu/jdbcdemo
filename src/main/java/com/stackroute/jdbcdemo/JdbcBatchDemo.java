package com.stackroute.jdbcdemo;

import java.sql.*;

public class JdbcBatchDemo {
    public void batchdDemo() {
        //loading driver and regestering with DriverManager
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Use driverMtanager to get Connections
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123")) {
            connection.setAutoCommit(false); //setting autocommit to false
            Statement statement = connection.createStatement();
            //adding batch of queries
            statement.addBatch("insert into Employee values(63,'srikar','m', 21)");
            statement.addBatch("insert into Employee values(90,'rajdeep','m',22)");
            statement.executeBatch();//executing the batch
            ResultSet resultSet = statement.executeQuery("Select * from Employee");
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name:" + resultSet.getString(2) +
                        " Gender:" + resultSet.getString(3) + " Age:" + resultSet.getInt(4));

            }
            System.out.println("-------------------------------------------------------------------------------");
            connection.commit(); //commit the connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}