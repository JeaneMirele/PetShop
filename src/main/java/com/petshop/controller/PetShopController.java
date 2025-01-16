package com.petshop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

            public class PetShopController {

                @FXML
                private Label Petshop;

                @FXML
                private AnchorPane cardsArea;

                @FXML
                private MenuItem tblFuncionario;

                @FXML
                private MenuItem tblProdutos;

                @FXML
                private MenuItem tblServicos;


                @FXML
                private void abrirTblFuncionario(ActionEvent event) throws Exception {
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

                        Stage stage = (Stage) ((javafx.scene.Node) event2.getSource()).getScene().getWindow();

                        Scene scene = new Scene(tblProduto);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }
            @FXML
            private void abrirTblServicos(ActionEvent event3) throws Exception {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/petshop/Scenes/tblServicos.fxml"));
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



