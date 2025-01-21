package com.petshop.controller;

import com.petshop.model.Produto;
import com.petshop.service.ProdutoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class TblProdutoController implements Initializable {
    @FXML
    private TextField Categoria;

    @FXML
    private TextField Descricao;

    @FXML
    private TextField Id;

    @FXML
    private TextField Nome;

    @FXML
    private TextField Qtd;

    @FXML
    private TextField Validade;

    @FXML
    private TextField Valor;

    @FXML
    private Button BuscarProduto;

    @FXML
    private Button DeleteProduto;

    @FXML
    private Button SaveProduto;

    @FXML
    private Button UpdateProduto;

    @FXML
    private Button LimparProduto;

    @FXML
    private TableColumn<Produto, String> ColumnCategoria;

    @FXML
    private TableColumn<Produto, String> ColumnDescricao;

    @FXML
    private TableColumn<Produto, Long> ColumnId;

    @FXML
    private TableColumn<Produto, String> ColumnNome;

    @FXML
    private TableColumn<Produto, Number> ColumnQtd;

    @FXML
    private TableColumn<Produto, LocalDate> ColumnValidade;

    @FXML
    private TableColumn<Produto, Number> ColumnValor;

    @FXML
    private TableView<Produto> tableView;

    private ProdutoService produtoService;


    public TblProdutoController() {
        this.produtoService = new ProdutoService();
    }

    @FXML
    void BuscarProduto(ActionEvent event) {
        String nome = Nome.getText();
        List<Produto> produtos = produtoService.findByName(nome);
        ObservableList<Produto> observableProdutos = FXCollections.observableArrayList(produtos);

        if (!produtos.isEmpty()) {
           tableView.setItems(observableProdutos);
        } else {
            showError("Nenhum produto encontrado com o nome informado.");
        }
    }

    @FXML
    void DeleteProduto(ActionEvent event) {
        Produto produtoSelecionado = tableView.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Exclusão");
        alert.setHeaderText("Tem certeza que deseja excluir o produto?");
        alert.setContentText("Esta ação não pode ser desfeita.");

        ButtonType buttonSim = new ButtonType("Sim");
        ButtonType buttonNao = new ButtonType("Não");
        alert.getButtonTypes().setAll(buttonSim, buttonNao);

        alert.showAndWait().ifPresent(response -> {
            if (response == buttonSim) {

                Long produtoId = produtoSelecionado.getId();
                boolean sucesso = produtoService.delete(produtoId);

                if (sucesso) {
                    tableView.getItems().remove(produtoSelecionado);
                    showSuccess("Produto excluído com sucesso.");
                } else {
                    showError("Erro ao excluir o produto.");
                }
            }
        });
    }

    @FXML
    void SaveProduto(ActionEvent event) {

        String nome = Nome.getText();
        String categoria = Categoria.getText();
        String descricao = Descricao.getText();
        Long qtdEstoque = Long.parseLong(Qtd.getText());
        Float valor = Float.parseFloat(Valor.getText());
        LocalDate validade = LocalDate.parse(Validade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Produto novoProduto = new Produto(nome, qtdEstoque, valor, validade, descricao, categoria);
        boolean sucesso = produtoService.save(novoProduto);
        if (sucesso) {
            tableView.setItems(FXCollections.observableList(produtoService.getProdutos()));
            showSuccess("Produto salvo com sucesso.");
        } else {
            showError("Erro ao salvar o produto.");
        }

    }


    @FXML
    void UpdateProduto(ActionEvent event) {
        Produto produtoSelecionado = tableView.getSelectionModel().getSelectedItem();

        if (produtoSelecionado != null) {
            String nome = Nome.getText();
            String categoria = Categoria.getText();
            String descricao = Descricao.getText();
            Long qtdEstoque = Long.parseLong(Qtd.getText());
            Float valor = Float.parseFloat(Valor.getText());
            LocalDate validade = LocalDate.parse(Validade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            produtoSelecionado.setNome(nome);
            produtoSelecionado.setCategoria(categoria);
            produtoSelecionado.setDescricao(descricao);
            produtoSelecionado.setQtdEstoque(qtdEstoque);
            produtoSelecionado.setValor(valor);
            produtoSelecionado.setDataValidade(validade);


            boolean sucesso = produtoService.update(produtoSelecionado);

            if (sucesso) {
                tableView.refresh();
                showSuccess("Produto atualizado com sucesso.");
            } else {
                showError("Selecione um produto para atualizar.");
            }
        }
    }


    @FXML
    void LimparProduto(ActionEvent event){

        Nome.clear();
        Categoria.clear();
        Descricao.clear();
        Qtd.clear();
        Valor.clear();
        Validade.clear();

    }


    private void showError(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void showSuccess(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        ColumnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        ColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        ColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColumnQtd.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));
        ColumnValidade.setCellValueFactory(new PropertyValueFactory<>("dataValidade"));
        tableView.setItems(FXCollections.observableList(produtoService.getProdutos()));
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue)-> {
           Produto p = newValue;
           Nome.setText(p.getNome());
           Categoria.setText(p.getCategoria());
           Descricao.setText(p.getDescricao());
           Qtd.setText(Long.toString(p.getQtdEstoque()));
           Valor.setText(Float.toString(p.getValor()));
           Validade.setText(p.getDataValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
        });

    }
}




