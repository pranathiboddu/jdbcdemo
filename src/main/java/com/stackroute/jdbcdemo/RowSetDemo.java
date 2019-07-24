package com.stackroute.jdbcdemo;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSetDemo {
    public void rowsetdemo()
    {
        JdbcRowSet rowSet = null;
        try {
            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/stackroute");
            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");
            rowSet.setCommand("select * from Employee");
            rowSet.execute();
            while (rowSet.next())
            {
                System.out.println("Id: " + rowSet.getInt(1) + " Name:" + rowSet.getString(2) +
                        " Gender:" + rowSet.getString(3) + " Age:" + rowSet.getInt(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
