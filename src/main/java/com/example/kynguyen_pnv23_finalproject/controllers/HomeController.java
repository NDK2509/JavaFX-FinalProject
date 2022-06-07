package com.example.kynguyen_pnv23_finalproject.controllers;

import com.example.kynguyen_pnv23_finalproject.MainController;
import com.example.kynguyen_pnv23_finalproject.models.Product;
import com.example.kynguyen_pnv23_finalproject.screens.HomeScreen;
import javafx.stage.Stage;

public class HomeController extends Controller{
    public HomeController(Stage stage) {
        super(stage);
    }

    @Override
    public void onCreate() {
        var productList = this.mg.getProductList();
        this.view(new HomeScreen(productList));
    }
    public void updateProduct(Product product) {
        this.mg.updateProduct(product);
    }
    public void deleteProduct(String id) {
        this.mg.deleteProduct(id);
    }
    public void switchToCreateProduct() {
        MainController.setController(new ProductController(this.baseStage));
    }
    public void logOut() {
        MainController.setController(new LoginController(this.baseStage));
    }

}
