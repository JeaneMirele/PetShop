package com.petshop.controller;

import com.petshop.model.Funcionario;
import com.petshop.repository.DBconnection;
import com.petshop.repository.FuncionarioDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;


public class FXMLCadastroFuncionarioController implements Initializable{
        private FuncionarioDao funcionarioDao;

        @FXML
        private Button btnAdd;

        @FXML
        private Button btnAlterar;

        @FXML
        private Button btnExcluir;

        @FXML
        private Label lblFuncionarioCargo;

        @FXML
        private Label lblFuncionarioNome;

        @FXML
        private Label lblFuncionarioSalario;

        @FXML
        private Label lblFuncionarioTelefone;

        @FXML
        private TableColumn<Funcionario, String> tblColumnCargo;

        @FXML
        private TableColumn<Funcionario, String> tblColumnNome;

        @FXML
        private TableColumn<Funcionario, Float> tblColumnSalario;

        @FXML
        private TableColumn<Funcionario, String> tblColumnTelefone;

        @FXML
        private TableView<Funcionario> tblViewFuncionarios;

        private List<Funcionario> funcionarios;
        private ObservableList<Funcionario> ObservableListFuncionario;
        private final Connection dBconnection = DBconnection.connect();

        @Override
        public void initialize(URL url, ResourceBundle rb){
                funcionarioDao = new FuncionarioDao();

                tblColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
                tblColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
                tblColumnSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
                tblColumnCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));

                CarregarTableViewFuncionarios();

        }
        public void CarregarTableViewFuncionarios(){
                List<Funcionario> funcionarios = funcionarioDao.findAll();
                ObservableListFuncionario = FXCollections.observableArrayList(funcionarios);
                tblViewFuncionarios.setItems(ObservableListFuncionario);
        }
    }

