package com.ucc.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String url = "jdbc:mysql://localhost:3306";
    private static String user = "root";
    private static String password = "Jacklb_192005";
    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getInstanceConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.getMessage());
            throw e;
        }
        return connection;
    }
       

}
