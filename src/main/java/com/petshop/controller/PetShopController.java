package com.petshop.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

        public class PetShopController {

            public void abrirCadastroFuncionario() {
                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/petshop/PetShopScene.fxml"));
                    Parent root = loader.load();

                    Scene scene = new Scene(root);

                    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

                    // Definir a nova cena no
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
