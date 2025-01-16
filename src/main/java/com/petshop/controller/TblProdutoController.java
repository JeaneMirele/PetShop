package com.petshop.controller;

import com.petshop.model.Produto;
import com.petshop.service.ProdutoService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class TblProdutoController {
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
    private TreeTableColumn<Produto, String> ColumnCategoria;

    @FXML
    private TreeTableColumn<Produto, String> ColumnDescricao;

    @FXML
    private TreeTableColumn<Produto, Long> ColumnId;

    @FXML
    private TreeTableColumn<Produto, String> ColumnNome;

    @FXML
    private TreeTableColumn<Produto, Number> ColumnQtd;

    @FXML
    private TreeTableColumn<Produto, LocalDate> ColumnValidade;

    @FXML
    private TreeTableColumn<Produto, Number> ColumnValor;

    @FXML
    private TreeTableView<Produto> treeTableView;

    private ProdutoService produtoService;


    public TblProdutoController() {
        this.produtoService = new ProdutoService();
    }

    @FXML
    void BuscarProduto(ActionEvent event) {
        String nome = Nome.getText();
        List<Produto> produtos = produtoService.findByName(nome);

        if (!produtos.isEmpty()) {
            atualizarTabela();
        } else {
            showError("Nenhum produto encontrado com o nome informado.");
        }
    }

    @FXML
    void DeleteProduto(ActionEvent event) {
        TreeItem<Produto> produtoSelecionadoItem = treeTableView.getSelectionModel().getSelectedItem();


        if (produtoSelecionadoItem != null) {
            Produto produtoSelecionado = produtoSelecionadoItem.getValue();
            boolean sucesso = produtoService.delete(produtoSelecionado.getId());

            if (sucesso) {
                treeTableView.getRoot().getChildren().remove(produtoSelecionado);
                showSuccess("Produto excluído com sucesso.");
                atualizarTabela();
            } else {
                showError("Erro ao excluir o produto.");
            }
        }
    }



    @FXML
    void SaveProduto(ActionEvent event) {
        Produto produto = coletarDadosDoFormulario();

        if (produto == null) {
            return;
        }

        boolean sucesso = produtoService.save(produto);

        if (sucesso) {
            showSuccess("Produto salvo com sucesso!");
            atualizarTabela();
        } else {
            showError("Erro ao salvar o produto.");
        }
    }


    @FXML
    void UpdateProduto(ActionEvent event) {
        TreeItem<Produto> produtoSelecionadoItem = treeTableView.getSelectionModel().getSelectedItem();
        if (produtoSelecionadoItem == null) {
            showError("Nenhum produto selecionado para atualizar.");
            return;
        }

        Produto produto = coletarDadosDoFormulario();

        if (produto == null) {
            return;
        }

        produto.setId(produtoSelecionadoItem.getValue().getId());

        boolean sucesso = produtoService.update(produto, null);

        if (sucesso) {
            showSuccess("Produto atualizado com sucesso!");
            atualizarTabela();
        } else {
            showError("Erro ao atualizar o produto.");
        }
    }


    public LocalDate capturarDataValidade() {
        String textoData = Validade.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate dataValidade = LocalDate.parse(textoData, formatter);
            return dataValidade;

        } catch (DateTimeParseException e) {
            System.err.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
            return null;
        }
    }
    private Produto coletarDadosDoFormulario() {
        String nome = Nome.getText();
        String descricao = Descricao.getText();
        String categoria = Categoria.getText();
        LocalDate dataValidade = capturarDataValidade();
        float valor;
        long qtd;

        try {
            valor = Float.parseFloat(Valor.getText());
            qtd = Long.parseLong(Qtd.getText());
        } catch (NumberFormatException e) {
            showError("Valor ou quantidade inválidos. Insira valores numéricos.");
            return null;
        }

        if (nome.isEmpty() || descricao.isEmpty() || categoria.isEmpty() || dataValidade == null) {


            System.out.println("Nome: " + nome);
            System.out.println("Descrição: " + descricao);
            System.out.println("Categoria: " + categoria);
            System.out.println("Data Validade: " + dataValidade);

            showError("Todos os campos devem ser preenchidos corretamente.");
            return null;
        }

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setCategoria(categoria);
        produto.setValor(valor);
        produto.setQtdEstoque(qtd);
        produto.setDataValidade(dataValidade);

        return produto;
    }

    private void atualizarTabela() {
        List<Produto> produtos = produtoService.getProdutos();
        ObservableList<Produto> observableProdutos = FXCollections.observableArrayList(produtos);


        TreeItem<Produto> root = new TreeItem<>();
        observableProdutos.forEach(produto -> root.getChildren().add(new TreeItem<>(produto)));

        treeTableView.setRoot(root);
        treeTableView.setShowRoot(false);

        ColumnCategoria.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCategoria()));
        ColumnDescricao.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getDescricao()));
        ColumnId.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getValue().getId()));
        ColumnNome.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getNome()));
        ColumnQtd.setCellValueFactory(param -> new SimpleLongProperty(param.getValue().getValue().getQtdEstoque()));
        ColumnValidade.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getValue().getDataValidade()));
        ColumnValor.setCellValueFactory(param -> new SimpleDoubleProperty(param.getValue().getValue().getValor()));
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

}




