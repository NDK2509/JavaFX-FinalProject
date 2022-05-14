package com.example.kynguyen_pnv23_finalproject;


import com.example.kynguyen_pnv23_finalproject.connectDB.DBConnection;
import com.example.kynguyen_pnv23_finalproject.screens.LoginScreen;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController extends Application {
    @Override
    public void start(Stage stage)  throws IOException{
        var con = new DBConnection();
        con.getAdminList().stream().forEach(System.out::println);
        var loginScreen = new LoginScreen(() -> {
//                    stage.setScene(new HomeScreen());
                    System.out.println("Next screen");
                 })
                .drawUI()
                .getScene();
        stage.setTitle("Hello, Welcome to NDK Shop!");
        stage.setScene(loginScreen);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}