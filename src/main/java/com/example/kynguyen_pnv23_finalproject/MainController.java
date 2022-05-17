package com.example.kynguyen_pnv23_finalproject;

import com.example.kynguyen_pnv23_finalproject.controllers.LoginController;
import com.example.kynguyen_pnv23_finalproject.screens.HomeScreen;
import com.example.kynguyen_pnv23_finalproject.screens.LoginScreen;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainController extends Application {
    @Override
    public void start(Stage stage) {
//        var manager = new Manager();
//        manager.getAdminList().stream().forEach(System.out::println);
        var loginScreen = new LoginScreen(
                new LoginController(
                        () -> {
                            stage.setScene(new HomeScreen().drawUI().getScene());
                            System.out.println("Next screen");
                        }
                )
        ).drawUI().getScene();
        stage.setTitle("Hello, Welcome to NDK Shop!");
        stage.setScene(loginScreen);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}