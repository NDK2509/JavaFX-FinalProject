package com.example.kynguyen_pnv23_finalproject.connectDB;

import java.sql.*;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost/ndkshop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    public MySQLConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect successfully!!!");
        } catch (SQLException e) {
            connection = null;
            System.out.println(e);
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
