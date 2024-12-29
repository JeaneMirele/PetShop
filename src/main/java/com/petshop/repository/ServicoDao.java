package com.petshop.repository;

import com.petshop.model.Produto;
import com.petshop.model.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServicoDao implements Dao<Servico>{

    @Override
    public Servico findById(Long id) {
        Servico servico = null;
        String sql = "select * from servico where id = ?";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            conn = DBconnection.connect();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id.intValue());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return servico;
}
