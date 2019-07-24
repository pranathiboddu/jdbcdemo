package com.stackroute.jdbcdemo;

import java.sql.*;

public class SimpleJdbcDemo {


    public void getEmployeeDetails() {
        //loading driver and regestering with DriverManager

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Use driverMtanager to get Connections
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from Employee");
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name:" + resultSet.getString(2) +
                        " Gender:" + resultSet.getString(3) + " Age:" + resultSet.getInt(4));
            }
            System.out.println("-------------------------------------------------------------------------------");

        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* catch (Exception e)
     {

     }
     finally {
         try {
             connection.close();
             statement.close();
             resultSet.close();

         } catch (SQLException e) {
             e.printStackTrace();
         }

     }*/
    //print resultset in reverseorder
    public void getEmployeeDetailsInReverseORder() {

            //loading driver and regestering with DriverManager

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123")) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from Employee");
                resultSet.afterLast();
                while (resultSet.previous()) {
                    System.out.println("Id: " + resultSet.getInt(1) + " Name:" + resultSet.getString(2) +
                            " Gender:" + resultSet.getString(3) + " Age:" + resultSet.getInt(4));

                }
                System.out.println("-------------------------------------------------------------------------------");

            }
            //Use driverMtanager to get Connections
            catch (SQLException e) {
                e.printStackTrace();
            }
        }



        //Move resultset to second row and print in reverse order
        public void getemployeeDetailsfromSecondRowInReverse () {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123")) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from Employee");
                resultSet.afterLast();
                while(resultSet.previous() &&(!resultSet.isFirst())){
                    System.out.println("Id: " + resultSet.getInt(1) + " Name:" + resultSet.getString(2) +
                            " Gender:" + resultSet.getString(3) + " Age:" + resultSet.getInt(4));

                }
                System.out.println("-------------------------------------------------------------------------------");

            }
            //Use driverMtanager to get Connections
            catch (SQLException e) {
                e.printStackTrace();
            }



        }


        //use preparedstatement to display by name and gender
        public void getEmployeeDetailsByNameAndGender (String name, String gender)
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stackroute", "root", "Root@123")) {
                PreparedStatement pst;
                String sql ="SELECT * FROM Employee WHERE empname=? and gender=?";
                pst = connection.prepareStatement(sql);
                pst.setString(1,name);
                pst.setString(2,gender);
                ResultSet resultSet = pst.executeQuery();

                while(resultSet.next()){

                    System.out.println("Id: " + resultSet.getInt(1) + " Name:" + resultSet.getString(2) +
                            " Gender:" + resultSet.getString(3) + " Age:" + resultSet.getInt(4));

                }
                System.out.println("-------------------------------------------------------------------------------");

            }
            //Use driverMtanager to get Connections
            catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }




