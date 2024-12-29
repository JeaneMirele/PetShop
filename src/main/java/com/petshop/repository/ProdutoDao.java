package com.petshop.repository;

import com.petshop.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDao implements Dao<Produto> {

    @Override
    public Produto findById(Long id) {
        Produto produto = null;
        String sql = "select * from produto where id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DBconnection.connect();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id.intValue());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return produto;
    }
}
