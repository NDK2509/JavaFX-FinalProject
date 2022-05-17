package com.example.kynguyen_pnv23_finalproject.controllers;

import com.example.kynguyen_pnv23_finalproject.models.Admin;
import com.example.kynguyen_pnv23_finalproject.screens.LoginScreen;
import javafx.scene.control.Alert;

public class LoginController {
    private OnValidLogin validLoginEvent;

    public LoginController(OnValidLogin event) {
        validLoginEvent = event;
    }
    private boolean isValidLogin(String userName, String password) {

        return false;
    }
    public void login(String userName, String password) {
        if (isValidLogin(userName, password)) {
            validLoginEvent.run();
            return;
        }
        var alert = new Alert(Alert.AlertType.WARNING, "Username or password is wrong!");
        alert.setHeaderText(null);
        alert.setTitle("Login warning!");
        alert.showAndWait();
    }
    public interface OnValidLogin {
        void run();
    }
}
