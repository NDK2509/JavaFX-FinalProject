package com.example.kynguyen_pnv23_finalproject.screens;

import com.example.kynguyen_pnv23_finalproject.controllers.Controller;
import javafx.scene.Scene;

public interface Screen {
    Scene getScene();
    Screen drawUI();
    void onUpdateUI();
}
