package com.example.kynguyen_pnv23_finalproject.controllers;

import com.example.kynguyen_pnv23_finalproject.Manager;
import com.example.kynguyen_pnv23_finalproject.screens.Screen;
import javafx.stage.Stage;

public abstract class Controller {
    protected Stage baseStage;
    protected Controller (Stage stage) {
        baseStage = stage;
    }
    protected final Manager mg = new Manager();
    public Manager getManager () {return mg;}
    public void view(Screen screen) {
        baseStage.setScene(screen.getScene());
        baseStage.show();
    }
}
