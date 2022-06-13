package com.example.kynguyen_pnv23_finalproject.screens;

import com.example.kynguyen_pnv23_finalproject.MainApplication;
import com.example.kynguyen_pnv23_finalproject.controllers.HomeController;
import com.example.kynguyen_pnv23_finalproject.models.*;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;

import java.util.List;

import static javafx.scene.control.cell.TextFieldTableCell.*;

public class HomeScreen implements Screen{
    public static final int BUTTON_WIDTH = 120;
    private Scene scene;
    private final List<Product> productList;

    public HomeScreen(List<Product> productList) {
        this.productList = productList;
        drawUI();
    }
    @Override
    public Scene getScene() {return scene;}
    @Override
    public HomeScreen drawUI() {
        var root = new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.setPadding(new Insets(50));
        drawHeader(root).drawLeft(root).drawRight(root);
        scene = new Scene(root, 1300, 600);
        return this;
    }
    private HomeScreen drawHeader(GridPane root) {
        var btnLogout = new Button("Log Out");
        var btnCreateProduct = new Button("Create Product");

        btnLogout.setOnAction(e -> ((HomeController) MainApplication.getController()).logOut());
        btnCreateProduct.setOnAction(e -> ((HomeController) MainApplication.getController()).switchToCreateProduct());
        root.add(btnLogout, 0, 0);
        root.add(btnCreateProduct, 1, 0);
        return this;
    }
    private HomeScreen drawLeft(GridPane root) {

        var btnProduct = new Button("Manage Product");
        btnProduct.setOnAction(e -> {
            MainApplication.getController().onCreate();
        });
        btnProduct.setMinWidth(BUTTON_WIDTH);
        btnProduct.setMaxWidth(BUTTON_WIDTH);


        var left = new VBox();
        left.getChildren().addAll(btnProduct);
        root.add(left, 0, 1);
        return this;
    }
    private HomeScreen drawRight(GridPane root) {
        var right = getProductBox();
        root.add(right, 1, 1);
        return this;
    }
    private VBox getProductBox() {
        var tblView = new TableView<Product>();
        tblView.setMinWidth(1000);
        tblView.setEditable(true);

        var nameCol = new TableColumn<Product, String>("Name");
        nameCol.setCellFactory(forTableColumn());
        nameCol.setOnEditCommit(e -> {
            var newName = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setName(newName);
            ((HomeController) MainApplication.getController()).updateProduct(product);
        } );
        var typeCol = new TableColumn<Product, String>("Type");
        typeCol.setCellFactory(forTableColumn());
        typeCol.setOnEditCommit(e -> {
            var newType = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setType(newType);
            ((HomeController) MainApplication.getController()).updateProduct(product);
        } );
        var priceCol = new TableColumn<Product, Integer>("Price");
        priceCol.setCellFactory(forTableColumn(new IntegerStringConverter()));
        priceCol.setOnEditCommit(e -> {
            var newPrice = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setPrice(newPrice);
            ((HomeController) MainApplication.getController()).updateProduct(product);
        } );
        var imgCol = new TableColumn<Product, String>("Img");
        imgCol.setMaxWidth(300);
        imgCol.setCellFactory(forTableColumn());
        imgCol.setOnEditCommit(e -> {
            var newImg = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setImg(newImg);
            ((HomeController) MainApplication.getController()).updateProduct(product);
        } );
        var colorCol = new TableColumn<Product, String>("Color");
        colorCol.setCellFactory(forTableColumn());
        colorCol.setOnEditCommit(e -> {
            var newColor = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setColor(newColor);
            ((HomeController) MainApplication.getController()).updateProduct(product);
        } );
        var specsCol = new TableColumn<Product, String>("Specifications");
        var internalMemoryCol = new TableColumn<Product, String>("Internal Memory");
        internalMemoryCol.setCellFactory(forTableColumn());
        internalMemoryCol.setOnEditCommit(e -> {
            var memo = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.getSpecs().setInternalMemory(memo);
            ((HomeController) MainApplication.getController()).updateProduct(product);
        } );
        var ramCol = new TableColumn<Product, String>("RAM");
        ramCol.setCellFactory(forTableColumn());
        ramCol.setOnEditCommit(e -> {
            var ram = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.getSpecs().setRam(ram);
            ((HomeController) MainApplication.getController()).updateProduct(product);
        } );
        var chargePortCol = new TableColumn<Product, String>("Charge Port");
        chargePortCol.setCellFactory(forTableColumn());
        chargePortCol.setOnEditCommit(e -> {
            var chargePort = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.getSpecs().setChargePort(chargePort);
            ((HomeController) MainApplication.getController()).updateProduct(product);
        } );
        var specialCol = new TableColumn<Product, String>("Special");
        specialCol.setCellFactory(forTableColumn());
        specialCol.setOnEditCommit(e -> {
            var special = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.getSpecs().setSpecial(special);
            ((HomeController) MainApplication.getController()).updateProduct(product);
        } );
        specsCol.getColumns().addAll(internalMemoryCol,ramCol, chargePortCol, specialCol);
        var deleteCol = new TableColumn<Product, Void>("Action");
        deleteCol.setCellFactory(column -> new TableCell<>() {
            private final Button btn = new Button("Delete");
            {
                btn.setOnAction((e) -> {
                    var product = getTableView().getItems().get(getIndex());
                    var controller =  (HomeController) MainApplication.getController();
                    controller.deleteProduct(product.getId());
                    controller.onCreate();
                });
            }
            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        imgCol.setCellValueFactory(new PropertyValueFactory<>("img"));
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        internalMemoryCol.setCellValueFactory(new PropertyValueFactory<>("internalMemory"));
        ramCol.setCellValueFactory(new PropertyValueFactory<>("ram"));
        chargePortCol.setCellValueFactory(new PropertyValueFactory<>("chargePort"));
        specialCol.setCellValueFactory(new PropertyValueFactory<>("special"));
        tblView.getColumns().addAll(nameCol, typeCol, priceCol, imgCol, colorCol, specsCol, deleteCol);
        tblView.setItems(FXCollections.observableArrayList(this.productList));

        var vb = new VBox();
        vb.getChildren().add(tblView);
        return vb;
    }
    private VBox getOrderBox() {
        var vb = new VBox();
        vb.getChildren().add(new Label("NDK order"));
        return vb;
    }
//    public abstract void moveToCreateProduct();
//    public abstract void logOut();
}
