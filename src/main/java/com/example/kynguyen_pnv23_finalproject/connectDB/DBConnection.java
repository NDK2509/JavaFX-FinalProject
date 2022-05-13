package com.example.kynguyen_pnv23_finalproject.connectDB;

import com.example.kynguyen_pnv23_finalproject.models.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost/ndkshop";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    public DBConnection() {
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
    public List<Admin> getAdminList() {
        ArrayList<Admin> list = new ArrayList<>();
        try {
            var result = connection.prepareStatement("SELECT * FROM admins").executeQuery();
            while (result.next()) {
                list.add(new Admin(
                        result.getString(1),
                        result.getString(2)
                        )
                );
            }
        } catch (SQLException e) {
            throw new Error("Can't query!!!" + e);
        }
        return list;
    }
}
