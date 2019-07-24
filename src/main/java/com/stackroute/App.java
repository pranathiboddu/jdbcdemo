package com.stackroute;

import com.stackroute.jdbcdemo.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {
        //created a instance of SimpleJdbcDemo class and calling methods of that class
        SimpleJdbcDemo simpleJdbcDemo=new SimpleJdbcDemo();

        System.out.println("Employee details:");
        simpleJdbcDemo.getEmployeeDetails();

        System.out.println("Employee details in reverse order:");
        simpleJdbcDemo.getEmployeeDetailsInReverseORder();

        System.out.println("Employee details from 2nd row to last in reverse order");
        simpleJdbcDemo.getemployeeDetailsfromSecondRowInReverse();

        System.out.println("Employee details by name and gender :");
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("varshini","f");

        //created a instance of DatabaseMetaDataemo class and calling methods of that class
        DatabaseMetadatDemo databaseMetadatDemo=new DatabaseMetadatDemo();

        System.out.println("Using  Database metadata:");
        databaseMetadatDemo.showDetails();

        //created a instance of ResultSetMetaDataDemo class and calling methods of that class
        ResultSetMetaDataDemo resultSetMetaDataDemo=new ResultSetMetaDataDemo();

        System.out.println("Using resultset metadata:");
        resultSetMetaDataDemo.metaDataDemo();


        //created a instance of JdbcBatchDemo class and calling methods of that class

       /* System.out.println("Batch Demo:");
        JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
        jdbcBatchDemo.batchdDemo();

        //created a instance of JdbcTransactionDemo class and calling methods of that class

        System.out.println("TransactionManagement demo:");
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.transactionmanagementdemo();*/

        //created a instance of RowSetDemo class and calling methods of that class
        System.out.println("RowSet Demo:");
        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.rowsetdemo();
    }
}
