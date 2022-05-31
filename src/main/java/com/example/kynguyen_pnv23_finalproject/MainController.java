package com.example.kynguyen_pnv23_finalproject;

import com.example.kynguyen_pnv23_finalproject.controllers.HomeController;
import com.example.kynguyen_pnv23_finalproject.controllers.LoginController;
import com.example.kynguyen_pnv23_finalproject.controllers.ProductController;
import com.example.kynguyen_pnv23_finalproject.screens.CreateProductScreen;
import com.example.kynguyen_pnv23_finalproject.screens.HomeScreen;
import com.example.kynguyen_pnv23_finalproject.screens.LoginScreen;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Application {
    @Override
    public void start(Stage stage) {
        var createProductScreen = new CreateProductScreen(
                new ProductController()
        ) {
            @Override
            public void onUpdateUI() {
                stage.setScene(this.drawUI().getScene());
            }
        }.drawUI();
        var homeScreen = new HomeScreen(
            new HomeController(
                () -> {
                    System.out.println("Log Out");
                    stage.close();
                }
            )
        ) {
            @Override
            public void onUpdateUI() {
                stage.setScene(this.drawUI().getScene());
            }
            @Override
            public void moveToCreateProduct() {
                stage.setScene(createProductScreen.getScene());
            }

        }.drawUI();
        //-------------
        var loginScreen = new LoginScreen(
            new LoginController(
                () -> {
                    stage.setScene(homeScreen.getScene());
                    System.out.println("Next screen");
                }
            )
        ) {
            @Override
            public void onUpdateUI() {}
        }.drawUI();
        stage.setTitle("Hello, Welcome to NDK Shop!");
        stage.setScene(homeScreen.getScene());
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}