package com.example.kynguyen_pnv23_finalproject.screens;

import com.example.kynguyen_pnv23_finalproject.controllers.HomeController;
import com.example.kynguyen_pnv23_finalproject.models.*;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;
import static javafx.scene.control.cell.TextFieldTableCell.*;

public abstract class HomeScreen implements Screen{

    public static final String PRODUCT_ACTION = "productAction";
    public static final String ORDER_ACTION = "orderAction";
    public static final int BUTTON_WIDTH = 120;
    private final HomeController CONTROLLER;
    private Scene scene;
    private String action = PRODUCT_ACTION;

    public HomeScreen(HomeController controller) {
        CONTROLLER = controller;
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
        scene = new Scene(root, 850, 600);
        return this;
    }
    private HomeScreen drawHeader(GridPane root) {
        var btnLogout = new Button("Log Out");
        btnLogout.setOnAction(e -> CONTROLLER.logOut());
        root.add(btnLogout, 0, 0, 2,1);
        return this;
    }
    private HomeScreen drawLeft(GridPane root) {

        var btnProduct = new Button("Manage Product");
        btnProduct.setOnAction(e -> {
            action = PRODUCT_ACTION;
            onUpdateUI();
        });
        btnProduct.setMinWidth(BUTTON_WIDTH);
        btnProduct.setMaxWidth(BUTTON_WIDTH);
        var btnOrder = new Button("Manage Order");
        btnOrder.setOnAction(e -> {
            action = ORDER_ACTION;
            onUpdateUI();
        });
        btnOrder.setMinWidth(BUTTON_WIDTH);
        btnOrder.setMaxWidth(BUTTON_WIDTH);
        var left = new VBox();
        left.getChildren().addAll(btnProduct, btnOrder);
        root.add(left, 0, 1);
        return this;
    }
    private HomeScreen drawRight(GridPane root) {
        var right = action.equals(PRODUCT_ACTION) ? getProductBox() : getOrderBox();
        root.add(right, 1, 1);
        return this;
    }
    private VBox getProductBox() {
        var tblView = new TableView<Product>();
        tblView.setMinWidth(600);
        tblView.setEditable(true);

        var nameCol = new TableColumn<Product, String>("Name");
        nameCol.setCellFactory(forTableColumn());
        nameCol.setOnEditCommit(e -> {
            var newName = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setName(newName);
            CONTROLLER.getManager().updateProduct(product);
        } );
        var typeCol = new TableColumn<Product, String>("Type");
        typeCol.setCellFactory(forTableColumn());
        typeCol.setOnEditCommit(e -> {
            var newType = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setType(newType);
        } );
        var priceCol = new TableColumn<Product, Integer>("Price");
        priceCol.setCellFactory(forTableColumn(new IntegerStringConverter()));
        priceCol.setOnEditCommit(e -> {
            var newPrice = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setPrice(newPrice);
        } );
        var imgCol = new TableColumn<Product, String>("Img");
        imgCol.setMaxWidth(300);
        imgCol.setCellFactory(forTableColumn());
        imgCol.setOnEditCommit(e -> {
            var newImg = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setType(newImg);
        } );
        var colorCol = new TableColumn<Product, String>("Color");
        colorCol.setCellFactory(forTableColumn());
        colorCol.setOnEditCommit(e -> {
            var newColor = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setType(newColor);
        } );
        var deleteCol = new TableColumn<String, String>("Action");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        imgCol.setCellValueFactory(new PropertyValueFactory<>("img"));
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));

        tblView.getColumns().addAll(nameCol, typeCol, priceCol, imgCol, colorCol);
        tblView.setItems(FXCollections.observableArrayList(CONTROLLER.getManager().getProductList()));

        var vb = new VBox();
        vb.getChildren().add(tblView);
        return vb;
    }
    private VBox getOrderBox() {
        var vb = new VBox();
        vb.getChildren().add(new Label("NDK order"));
        return vb;
    }
}