package com.petshop.repository;

import com.petshop.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao implements Dao<Produto> {

    private boolean executeUpdate(String sql, Object... params) {
        try (Connection conn = DBconnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            // Preenche os parâmetros da query
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    private List<Produto> executeQuery(String sql, Object... params) {
        List<Produto> products = new ArrayList<>();
        try (Connection conn = DBconnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Produto produto = new Produto();
                    produto.setId(resultSet.getLong("id_prod"));
                    produto.setNome(resultSet.getString("nome"));
                    produto.setQtdEstoque(resultSet.getLong("qtd_estoque"));
                    produto.setValor(resultSet.getFloat("valor"));
                    produto.setDataValidade(resultSet.getTimestamp("data_validade").toLocalDateTime());
                    produto.setDescricao(resultSet.getString("descricao"));
                    produto.setCategoria(resultSet.getString("categoria"));
                    products.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Produto findById(Long id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        List<Produto> products = executeQuery(sql, id);
        return products.isEmpty() ? null : products.get(0);
    }

    @Override
    public List<Produto> findAll() {
        String sql = "SELECT * FROM produto";
        return executeQuery(sql);
    }

    @Override
    public boolean save(Produto produto) {
        String sql = "INSERT INTO produto (nome, qtd_estoque, valor, data_validade, descricao, categoria) VALUES (?, ?, ?, ?, ?, ?)";
        return executeUpdate(sql, produto.getNome(), produto.getQtdEstoque(), produto.getValor(), produto.getDataValidade(), produto.getDescricao(), produto.getCategoria());
    }

    @Override
    public boolean update(Produto produto, String[] params) {
        String sql = "UPDATE produto SET nome = ?, qtd_estoque = ?, valor = ?, data_validade = ?, descricao = ?, categoria = ? WHERE id = ?";
        return executeUpdate(sql, produto.getNome(), produto.getQtdEstoque(), produto.getValor(), produto.getDataValidade(), produto.getDescricao(), produto.getCategoria());
    }

    @Override
    public boolean delete(Long id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        return executeUpdate(sql, id);
    }
}



