package com.ucc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ucc.Connection.DatabaseConnection;
import com.ucc.Repository.ActorRepository;
import com.ucc.Repository.IRepository;


public class Main {
    public static void main(String[] args) throws SQLException {
        try(Connection myConn = DatabaseConnection.getInstanceConnection()){

            IRepository repository = new ActorRepository();
            repository.findAll().forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Conexion Fail");
        } 
    }
}   