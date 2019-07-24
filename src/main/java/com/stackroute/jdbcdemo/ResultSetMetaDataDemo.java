package com.stackroute.jdbcdemo;

import java.sql.*;

public class ResultSetMetaDataDemo {
    public void metaDataDemo() {
        //loading driver and regestering with DriverManager
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Use driverMtanager to get Connections
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123")) {
            //used prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Employee");
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();//created instance of resultsetmetadata
            //called different methods of resultsetmetadata
            System.out.println("Total columns: " + resultSetMetaData.getColumnCount());
            System.out.println("Column Name of 1st column: " + resultSetMetaData.getColumnName(1));
            System.out.println("Column Type Name of 1st column: " + resultSetMetaData.getColumnTypeName(1));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
