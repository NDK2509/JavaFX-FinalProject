package com.example.kynguyen_pnv23_finalproject.screens;

import com.example.kynguyen_pnv23_finalproject.controllers.HomeController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HomeScreen implements Screen{
    private GridPane root;
    private HomeController controller;
    public HomeScreen() {
        root = new GridPane();
        controller = new HomeController();
    }
    @Override
    public Scene getScene() {return new Scene(root, 600, 600);}
    @Override
    public HomeScreen drawUI() {
        var btnProduct = new Button("Product");
        btnProduct.setOnAction(e -> {} );

        return this;
    }
}
