package com.stackroute.jdbcdemo;

import com.mysql.cj.jdbc.DatabaseMetaData;

import java.sql.*;

public class DatabaseMetadatDemo {

    public void showDetails(){

        //loading driver and regestering with DriverManager
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Use driverMtanager to get Connections
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123")) {
            Statement statement = connection.createStatement();
            DatabaseMetaData dbmd= (DatabaseMetaData) connection.getMetaData(); //cretae instance of databasemetadata
            String table[]={"TABLE"}; //cretae a table of string array which counts the total umber of tables
            ResultSet rs=dbmd.getTables(null,null,null,table);

            while(rs.next()){
                System.out.println(rs.getString(3));
            }
            System.out.println("-----------------------------------------");
                //uding different methods of databasemetadata
            System.out.println("Driver Name: "+dbmd.getDriverName());
            System.out.println("Driver Version: "+dbmd.getDriverVersion());
            System.out.println("UserName: "+dbmd.getUserName());
            System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
            System.out.println("----------------------------------------------------------");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}