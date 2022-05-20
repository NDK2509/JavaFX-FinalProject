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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public abstract class HomeScreen implements Screen{

    public static final String PRODUCT_ACTION = "productAction";
    public static final String ORDER_ACTION = "orderAction";
    private final HomeController CONTROLLER;
    private Scene scene;
    private VBox right = new VBox();
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
        var btnLogout = new Button("Log Out");
        btnLogout.setOnAction(e -> CONTROLLER.logOut());
        var btnProduct = new Button("Manage Product");
        btnProduct.setOnAction(e -> {
            action = PRODUCT_ACTION;
            onUpdateUI();
        });
        var btnOrder = new Button("Manage Order");
        btnOrder.setOnAction(e -> {
            action = ORDER_ACTION;
            onUpdateUI();
        });
        var left = new VBox();
        left.getChildren().addAll(btnProduct, btnOrder);

        right = action.equals(PRODUCT_ACTION) ? getProductBox() : getOrderBox();
        root.add(btnLogout, 0, 0, 2,1);
        root.add(left, 0, 1);
        root.add(right, 1, 1);
        scene = new Scene(root, 800, 600);
        return this;
    }
    private VBox getProductBox() {
        var tblView = new TableView<Product>();
        tblView.setMinWidth(550);
        tblView.setEditable(true);

        var nameCol = new TableColumn<Product, String>("Name");
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(e -> {
            var newName = e.getNewValue();
            var product = e.getTableView().getItems().get(e.getTablePosition().getRow());
            product.setName(newName);
        } );

        var typeCol = new TableColumn<Product, String>("Type");
        var priceCol = new TableColumn<Product, Double>("Price");
        var imgCol = new TableColumn<Product, String>("img");
        imgCol.setMaxWidth(300);
        var colorCol = new TableColumn<Product, String>("color");
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
