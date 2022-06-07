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
//        var createProductScreen = new CreateProductScreen(new ProductController(stage)) {
//            @Override
//            public void onUpdateUI() {
//                stage.setScene(this.drawUI().getScene());
//            }
//        };
//        var homeScreen = new HomeScreen(new HomeController(stage)) {
//            @Override
//            public void onUpdateUI() {
//                stage.setScene(this.drawUI().getScene());
//            }
//            @Override
//            public void moveToCreateProduct() {
//                stage.setScene(createProductScreen.getScene());
//            }
//
//            @Override
//            public void logOut() {
//                stage.close();
//            }
//        };
//        //-------------
//        var loginScreen = new LoginScreen(new LoginController(stage)) {
//            @Override
//            public void moveToHomeScreen() {
//                stage.setScene(homeScreen.getScene());
//            }
//
//            @Override
//            public void onUpdateUI() {}
//        };
//        stage.setTitle("Hello, Welcome to NDK Shop!");
//        stage.setScene(loginScreen.getScene());
//        stage.show();
        var loginController = new LoginController(stage);
        loginController.login();
    }

    public static void main(String[] args){
        launch();
    }
}