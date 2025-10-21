package com.ucc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "Jacklb_192005";
        try(Connection myConn = DriverManager.getConnection(url, user, password);
        ){
        String sql = "INSERT INTO sakila.actor(first_name, last_name) VALUES (?,?)";
        PreparedStatement myPrepare = myConn.prepareStatement(sql);
        myPrepare.setString(1, "Nombre Aleatorio");
        myPrepare.setString(2, "Apellido Aleatorio");
        
        int filasAfectadas = myPrepare.executeUpdate();

        if(filasAfectadas > 0){
            System.out.println("Se creo el actor correctamente");
        }

        } catch (Exception e) {
            System.out.println("Conexion Fail");
        } 
    }
}   