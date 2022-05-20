package com.example.kynguyen_pnv23_finalproject.models;

public class Admin {
    private final String userName;
    private final String password;

    public Admin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Admin admin) {
            return userName.equals(admin.getUserName()) && password.equals(admin.getPassword());
        }
        return false;
    }
    @Override
    public String toString() {
        return "admin: "+ userName + " password: " + password;
    }
}
