package com.example.kynguyen_pnv23_finalproject.screens;

import com.example.kynguyen_pnv23_finalproject.controllers.LoginController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public abstract class LoginScreen implements Screen{
    private Scene scene;
    private final GridPane ROOT = new GridPane();
    private final LoginController CONTROLLER;

    public LoginScreen(LoginController controller){
        CONTROLLER = controller;
    }
    @Override
    public Scene getScene() {
        return this.scene;
    }

    @Override
    public LoginScreen drawUI() {
        ROOT.setAlignment(Pos.CENTER);
        ROOT.setHgap(20);
        ROOT.setVgap(20);
        var txtUsername = new TextField();
        var txtPassword = new PasswordField();
        var lbLogin = new Label("LOGIN");
        lbLogin.setFont(new Font(50));
        lbLogin.setMaxWidth(Double.MAX_VALUE);
        lbLogin.setAlignment(Pos.CENTER);
        var btnLogin = new Button("Login");
        btnLogin.setMaxWidth(Double.MAX_VALUE);
        btnLogin.setOnAction((e) -> CONTROLLER.login(txtUsername.getText(), txtPassword.getText()));
        ROOT.add(lbLogin, 0, 0, 2, 1);
        ROOT.add(new Label("Username: "), 0, 1);
        ROOT.add(txtUsername, 1,1);
        ROOT.add(new Label("Password: "), 0, 2);
        ROOT.add(txtPassword, 1, 2);
        ROOT.add(btnLogin, 0, 3, 2, 1);

        scene = new Scene(ROOT, 600, 600);
        return this;
    }
}
