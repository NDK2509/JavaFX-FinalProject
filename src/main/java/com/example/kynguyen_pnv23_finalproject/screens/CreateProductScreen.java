package com.example.kynguyen_pnv23_finalproject.screens;

import com.example.kynguyen_pnv23_finalproject.MainController;
import com.example.kynguyen_pnv23_finalproject.controllers.HomeController;
import com.example.kynguyen_pnv23_finalproject.controllers.ProductController;
import com.example.kynguyen_pnv23_finalproject.models.Product;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CreateProductScreen implements Screen {
    private Scene scene;
    public CreateProductScreen() {
        drawUI();
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }
    @Override
    public Screen drawUI() {
        var root = new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));
        drawForm(root);
        scene = new Scene(root, 850, 600);
        System.out.println("draw create");
        return this;
    }
    private CreateProductScreen drawForm(GridPane root) {
        var lbName = new Label("Name");
        var lbPrice = new Label("Price");
        var lbImg = new Label("Image");
        var lbType = new Label("Type");
        var lbColor = new Label("Color");
        var lbInternalMemory = new Label("Internal Memory");
        var lbRam = new Label("Ram");
        var lbChargePort = new Label("Charge Port");
        var lbSpecial = new Label("Special");

        var txtName = new TextField();
        var txtPrice = new TextField();
        var txtImg = new TextField();
        var txtType = new TextField();
        var txtColor = new TextField();
        var txtInternalMemory = new TextField();
        var txtRam = new TextField();
        var txtChargePort = new TextField();
        var txtSpecial = new TextField();

        var btnSave = new Button("Save");
        btnSave.setOnAction(e -> {
            ((ProductController) MainController.getController())
                .create(
                    new Product(
                        txtName.getText(),
                        Integer.parseInt(txtPrice.getText()),
                        txtImg.getText(),
                        txtType.getText(),
                        txtColor.getText(),
                        new Product.Specs(
                            txtInternalMemory.getText(),
                            txtRam.getText(),
                            txtChargePort.getText(),
                            txtSpecial.getText()
                        )
                    )
                );
            ((ProductController) MainController.getController()).switchToHome();
        });
        var hbBtnSave = new HBox();
        hbBtnSave.getChildren().add(btnSave);
        hbBtnSave.setAlignment(Pos.CENTER);

        root.add(lbName, 0 ,0);
        root.add(txtName, 1, 0);
        root.add(lbPrice, 0 ,1);
        root.add(txtPrice, 1, 1);
        root.add(lbImg, 0 ,2);
        root.add(txtImg, 1, 2);
        root.add(lbType, 0 ,3);
        root.add(txtType, 1, 3);
        root.add(lbColor, 0 ,4);
        root.add(txtColor, 1, 4);
        root.add(lbInternalMemory, 0 ,5);
        root.add(txtInternalMemory, 1, 5);
        root.add(lbRam, 0 ,6);
        root.add(txtRam, 1, 6);
        root.add(lbChargePort, 0 ,7);
        root.add(txtChargePort, 1, 7);
        root.add(lbSpecial, 0 ,8);
        root.add(txtSpecial, 1, 8);
        root.add(hbBtnSave, 0 ,9, 2, 1);


        return this;
    }
}
