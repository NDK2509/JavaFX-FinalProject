package com.example.kynguyen_pnv23_finalproject;

import java.sql.*;

import com.example.kynguyen_pnv23_finalproject.connectDB.MongoDBConnection;
import com.example.kynguyen_pnv23_finalproject.connectDB.MySQLConnection;
import com.example.kynguyen_pnv23_finalproject.models.Admin;
import com.mongodb.client.MongoDatabase;

import java.sql.SQLException;
import java.util.ArrayList;

public class Manager {
    private Connection connection = new MySQLConnection().getConnection();
    private MongoDatabase mgDB = new MongoDBConnection().getDataBase();
    public ArrayList<Admin> getAdminList() {
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
    public void mgTest() {
        mgDB.getCollection("admins").find().forEach(doc -> System.out.println(doc.getString("userName")));
    }
}
