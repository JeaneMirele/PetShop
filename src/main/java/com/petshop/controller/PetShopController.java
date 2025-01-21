package com.petshop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Label;


            public class PetShopController {

                @FXML
                private Label Petshop;

                @FXML
                private void Entrar(ActionEvent event4) throws Exception {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/petshop/Scenes/MenuCadastro.fxml"));
                        Parent menuCadastro= loader.load();

                        Stage stage = (Stage) ((javafx.scene.Node) event4.getSource()).getScene().getWindow();

                        Scene scene = new Scene(menuCadastro);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
            }





