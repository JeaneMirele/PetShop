package com.petshop.controller;
import com.petshop.model.Funcionario;
import com.petshop.model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.List;

public class FuncionarioController {

        @FXML
        private Button Buscar;

        @FXML
        private TextField Cargo;

        @FXML
        private Button Excluir;

        @FXML
        private Button Limpar;

        @FXML
        private TextField Nome;

        @FXML
        private Button Salvar;

        @FXML
        private TextField Telefone;

        @FXML
        private Button Update;

        @FXML
        private TableView tblFuncionario;
        @FXML
        private TextField salario;

        @FXML
        private HBox tblPet;

        @FXML
        void Buscar(ActionEvent event) {
                String nome = Nome.getText();
                List<Funcionario> funcionario = FuncionarioService.findByName(nome);
                ObservableList<Produto> observableProdutos = FXCollections.observableArrayList(produtos);

                if (!produtos.isEmpty()) {
                    tableView.setItems(observableProdutos);
                } else {
                    showError("Nenhum produto encontrado com o nome informado.");
                }
            }
        }

        @FXML
        void Excluir(ActionEvent event) {

        }

        @FXML
        void Limpar(ActionEvent event) {

        }

        @FXML
        void Salvar(ActionEvent event) {

        }


        @FXML
        void Update(ActionEvent event) {

        }



    }

}
