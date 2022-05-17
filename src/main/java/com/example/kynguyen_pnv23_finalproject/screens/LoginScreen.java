package com.example.kynguyen_pnv23_finalproject.screens;

import com.example.kynguyen_pnv23_finalproject.Manager;
import com.example.kynguyen_pnv23_finalproject.controllers.LoginController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class LoginScreen implements Screen{

    private GridPane root;
    private TextField txtUsername;
    private TextField txtPassword;
    private LoginController controller;

    public LoginScreen(LoginController controller){
        root = new GridPane();
        txtUsername = new TextField();
        txtPassword = new PasswordField();
        this.controller = controller;
    }
    public Scene getScene() {
        return new Scene(root, 600, 600);
    }
    @Override
    public LoginScreen drawUI() {
        root.setAlignment(Pos.CENTER);
        root.setHgap(20);
        root.setVgap(20);
        var lbLogin = new Label("LOGIN");
        lbLogin.setFont(new Font(50));
        lbLogin.setMaxWidth(Double.MAX_VALUE);
        lbLogin.setAlignment(Pos.CENTER);
        var btnLogin = new Button("Login");
        btnLogin.setMaxWidth(Double.MAX_VALUE);
        btnLogin.setOnAction((e) -> controller.login(txtUsername.getText(), txtPassword.getText()));
        root.add(lbLogin, 0, 0, 2, 1);
        root.add(new Label("Username: "), 0, 1);
        root.add(txtUsername, 1,1);
        root.add(new Label("Password: "), 0, 2);
        root.add(txtPassword, 1, 2);
        root.add(btnLogin, 0, 3, 2, 1);

        return this;
    }
}
