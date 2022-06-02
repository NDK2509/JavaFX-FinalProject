package com.example.kynguyen_pnv23_finalproject.controllers;

import javafx.scene.control.Alert;

public class LoginController extends Controller{
//    private LoginScreenEvent event;

//    public LoginController(LoginScreenEvent event) {
//        this.event = event;
//    }
    public LoginController() {}
//    public void login(String userName, String password) {
//        if (isValidLogin(userName, password)) {
//            event.onValidLogin();
//            return;
//        }
//        loginFailNotify();
//    }

    public void loginFailNotify() {
        var alert = new Alert(Alert.AlertType.WARNING, "Username or password is wrong!");
        alert.setHeaderText(null);
        alert.setTitle("Login warning!");
        alert.showAndWait();
    }

    public boolean isValidLogin(String userName, String password) {
        var admin = mg.getAdminByUserName(userName);
        return admin != null && admin.getPassword().equals(password);
    }
    public interface LoginScreenEvent {
        void onValidLogin();
    }
}
