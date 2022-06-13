package com.example.kynguyen_pnv23_finalproject.controllers;

import com.example.kynguyen_pnv23_finalproject.MainApplication;
import com.example.kynguyen_pnv23_finalproject.models.Product;
import com.example.kynguyen_pnv23_finalproject.screens.CreateProductScreen;
import javafx.stage.Stage;

public class ProductController extends Controller{
    public ProductController(Stage stage) {
        super(stage);
    }

    @Override
    public void onCreate() {
        this.view(new CreateProductScreen());
    }
    public void create(Product product) {
        this.mg.createProduct(product);
    }
    public void switchToHome() {
        MainApplication.setController(new HomeController(this.baseStage));
    }
}
