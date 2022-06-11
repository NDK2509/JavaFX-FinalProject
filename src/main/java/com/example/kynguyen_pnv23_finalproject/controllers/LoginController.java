package com.example.kynguyen_pnv23_finalproject.controllers;

import com.example.kynguyen_pnv23_finalproject.MainApplication;
import com.example.kynguyen_pnv23_finalproject.screens.LoginScreen;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class LoginController extends Controller{
    public LoginController(Stage stage) {
        super(stage);
    }
    @Override
    public void onCreate() {
        this.view(new LoginScreen());
    }
    public void login(String userName, String password) {
        if (isValidLogin(userName, password)) {
            MainApplication.setController(new HomeController(this.baseStage));
            return;
        }
        loginFailNotify();
    }
    private void loginFailNotify() {
        var alert = new Alert(Alert.AlertType.WARNING, "Username or password is wrong!");
        alert.setHeaderText(null);
        alert.setTitle("Login warning!");
        alert.showAndWait();
    }

    private boolean isValidLogin(String userName, String password) {
        var admin = mg.getAdminByUserName(userName);
        return admin != null && admin.getPassword().equals(password);
    }
    public interface LoginScreenEvent {
        void onValidLogin();
    }
}
