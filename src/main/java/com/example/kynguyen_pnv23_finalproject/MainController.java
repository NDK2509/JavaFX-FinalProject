package com.example.kynguyen_pnv23_finalproject;

import com.example.kynguyen_pnv23_finalproject.controllers.Controller;
import com.example.kynguyen_pnv23_finalproject.controllers.LoginController;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainController extends Application {
    private static Controller controller;
    public static Controller getController() {return controller;}
    public static void setController(Controller newController) {controller = newController;}
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
        controller = new LoginController(stage);
    }

    public static void main(String[] args){
        launch();
    }
}