package com.example.kynguyen_pnv23_finalproject;

import java.sql.*;

import com.example.kynguyen_pnv23_finalproject.connectDB.DBConnection;
import com.example.kynguyen_pnv23_finalproject.models.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private Connection connection = new DBConnection().getConnection();
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
