package com.petshop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FuncionarioController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}