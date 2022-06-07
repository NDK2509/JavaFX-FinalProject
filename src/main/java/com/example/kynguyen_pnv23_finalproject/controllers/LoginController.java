package com.example.kynguyen_pnv23_finalproject.controllers;

import com.example.kynguyen_pnv23_finalproject.screens.LoginScreen;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class LoginController extends Controller{
    public LoginController(Stage stage) {
        super(stage);
    }
    public void login() {
        this.view(new LoginScreen() {
            @Override
            public void moveToHomeScreen() {

            }
            @Override
            public void onUpdateUI() {

            }
        });
    }
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
