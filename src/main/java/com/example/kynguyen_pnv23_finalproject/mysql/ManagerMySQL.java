package com.example.kynguyen_pnv23_finalproject.mysql;

import com.example.kynguyen_pnv23_finalproject.connectDB.MySQLConnection;
import com.example.kynguyen_pnv23_finalproject.models.Admin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerMySQL {
    private Connection connection = new MySQLConnection().getConnection();
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
}
