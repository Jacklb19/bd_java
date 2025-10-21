package com.ucc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ucc.Connection.DatabaseConnection;


public class Main {
    public static void main(String[] args) throws SQLException {
        try(Connection myConn = DatabaseConnection.getInstanceConnection();
            Statement myStat = myConn.createStatement();
            ResultSet myRes= myStat.executeQuery("Select * from sakila.actor");
            ){

            while (myRes.next()) {
                System.out.println(myRes.getString("first_name")
                +" "+ myRes.getString("last_name"));
            }

        } catch (Exception e) {
            System.out.println("Conexion Fail");
        } 
    }
}   