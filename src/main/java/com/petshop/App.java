package com.petshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

    public class App extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {

            try {
                Parent root = FXMLLoader.load(getClass().getResource("Scenes/PetshopScene.fxml"));
                Scene scene = new Scene(root);

                scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());

                primaryStage.setScene(scene);
                primaryStage.setResizable(true);
                primaryStage.sizeToScene();
                primaryStage.setTitle("PetShop");
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            launch(args);
        }
    }


