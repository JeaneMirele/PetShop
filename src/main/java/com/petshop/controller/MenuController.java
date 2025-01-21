package com.petshop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;


    public class MenuController {

        @FXML
        private SubScene subScene;

        @FXML
        private Button Funcionarios;

        @FXML
        private Button Pet;

        @FXML
        private Button Produtos;

        @FXML
        private Button Serviços;



        @FXML
        void abrirTblPet(ActionEvent event) {

        }




    @FXML
    private void abrirTblFuncionarios(ActionEvent event) throws Exception {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/petshop/Scenes/TblFuncionario.fxml"));
            Parent tblFuncionario = loader.load();

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(tblFuncionario);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @FXML
        private void abrirTblProdutos(ActionEvent event2) throws Exception {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/petshop/Scenes/tblProdutos.fxml"));
                Parent tblProduto = loader.load();
                subScene.setRoot(tblProduto);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @FXML
        private void abrirTblServicos(ActionEvent event3) throws Exception {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/petshop/Scenes/TblServiços.fxml"));
                Parent tblServicos = loader.load();

                Stage stage = (Stage) ((javafx.scene.Node) event3.getSource()).getScene().getWindow();

                Scene scene = new Scene(tblServicos);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private void abrirTblAgendamentos(ActionEvent event4) throws Exception {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/petshop/Scenes/tblAgendamentos.fxml"));
                Parent tblAgendamentos = loader.load();

                Stage stage = (Stage) ((javafx.scene.Node) event4.getSource()).getScene().getWindow();

                Scene scene = new Scene(tblAgendamentos);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
