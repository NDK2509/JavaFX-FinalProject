package com.example.kynguyen_pnv23_finalproject.screens;

import com.example.kynguyen_pnv23_finalproject.controllers.Controller;
import javafx.scene.Scene;

public interface Screen {
    Screen drawUI();
    Scene getScene();
    void onUpdateUI();
}
